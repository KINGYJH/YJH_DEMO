package com.yjh.demo.interfaces.account.web;

import com.yjh.demo.application.account.IAccountAppService;
import com.yjh.demo.application.account.command.*;
import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.common.Constants;
import com.yjh.demo.core.exception.ConcurrencyException;
import com.yjh.demo.core.exception.ExistException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.core.upload.IFileUploadService;
import com.yjh.demo.core.upload.UploadResult;
import com.yjh.demo.core.upload.UploadSuccess;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import com.yjh.demo.interfaces.shared.web.AlertMessage;
import com.yjh.demo.interfaces.shared.web.BaseController;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by YJH on 2016/3/31.
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.toString());

    @Autowired
    private IAccountAppService accountAppService;

    @Autowired
    private IFileUploadService fileUploadService;

    @RequestMapping(value = "/pagination.htm")
    public ModelAndView pagination(ListAccountCommand command) {
        return new ModelAndView("/account/list", "pagination", accountAppService.pagination(command)).addObject("command", command);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Pagination<AccountRepresentation> list(@RequestBody ListAccountCommand command) {
        return accountAppService.paginationJSON(command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("command") CreateAccountCommand command) {
        return new ModelAndView("/account/create", "command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("command") CreateAccountCommand command, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/account/create");
        }
        AlertMessage alertMessage;
        AccountRepresentation account;
        try {
            account = accountAppService.create(command);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            if (e.getMessage().indexOf("AppKey") != -1) {
                alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                        this.getMessage("appKey.id.not.found.messages", new Object[]{command.getAppKey()}, locale));
            } else {
                alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                        this.getMessage("role.id.not.found.messages", new Object[]{command.getRoles()}, locale));
            }
            return new ModelAndView("/account/create", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (ExistException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("account.accountName.Exist.Messages", new Object[]{command.getUserName()}, locale));
            return new ModelAndView("/account/create", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        logger.info("创建User[" + account.getUserName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.create.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", account.getId());
        return new ModelAndView("redirect:/account/info.htm/{id}");
    }

    @RequestMapping(value = "/info.htm/{id}")
    public ModelAndView info(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AccountRepresentation account;
        try {
            account = accountAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/account/info", "account", account);
    }

    @RequestMapping(value = "/edit.htm/{id}")
    public ModelAndView edit(@PathVariable String id, @ModelAttribute("command") EditAccountCommand command,
                             RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AccountRepresentation account;
        try {
            account = accountAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/account/edit", "account", account).addObject("command", command);
    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("command") EditAccountCommand command, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/account/edit", "command", command);
        }
        AlertMessage alertMessage;
        AccountRepresentation account;
        try {
            account = accountAppService.edit(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/account/edit.htm/{id}");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            if (e.getMessage().indexOf("AppKey") != -1) {
                alertMessage = new AlertMessage(this.getMessage("appKey.id.not.found.messages", new Object[]{command.getAppKey()}, locale));
            } else if (e.getMessage().indexOf("Role") != -1) {
                alertMessage = new AlertMessage(this.getMessage("role.id.not.found.messages", new Object[]{command.getRoles()}, locale));
            } else {
                alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{command.getId()}, locale));
                redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
                return new ModelAndView("redirect:/account/pagination.htm");
            }
            return new ModelAndView("/account/edit", "command", command).addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改User[" + account.getUserName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", account.getId());
        return new ModelAndView("redirect:/account/info.htm/{id}");
    }

    @RequestMapping(value = "/update_status")
    public ModelAndView updateStatus(SharedCommand command, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        try {
            accountAppService.updateStatus(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改User[" + command.getId() + "]状态成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/account/pagination.htm");
    }

    @RequestMapping(value = "/reset_password.htm/{id}", method = RequestMethod.GET)
    public ModelAndView resetPassword(@PathVariable String id, @ModelAttribute("command") ResetPasswordCommand command,
                                      RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AccountRepresentation account;
        try {
            account = accountAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/account/resetPassword", "account", account).addObject("command", command);
    }

    @RequestMapping(value = "/reset_password.htm", method = RequestMethod.POST)
    public ModelAndView resetPassword(@Valid @ModelAttribute("command") ResetPasswordCommand command, BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes, Locale locale) {

        if (bindingResult.hasErrors()) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("account.password.NotBlank.messages", null, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/account/reset_password.htm/{id}");
        }

        AlertMessage alertMessage;
        try {
            accountAppService.resetPassword(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/account/reset_password.htm/{id}");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("重置User[" + command.getId() + "]密码成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/account/pagination.htm");
    }

    @RequestMapping(value = "/authorize.htm/{id}", method = RequestMethod.GET)
    public ModelAndView authorize(@PathVariable String id, @ModelAttribute("command") AuthorizeAccountCommand command,
                                  RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AccountRepresentation account;
        try {
            account = accountAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/account/authorize", "account", account).addObject("command", command);
    }

    @RequestMapping(value = "/authorize.htm", method = RequestMethod.POST)
    public ModelAndView authorize(@Valid @ModelAttribute("command") AuthorizeAccountCommand command, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        try {
            accountAppService.authorized(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/account/authorize.htm/{id}");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            if (e.getMessage().indexOf("Role") != -1) {
                alertMessage = new AlertMessage(this.getMessage("role.id.not.found.messages", new Object[]{command.getRoles()}, locale));
                redirectAttributes.addAttribute("id", command.getId());
                redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
                return new ModelAndView("redirect:/account/authorize.htm/{id}");
            } else {
                alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{command.getId()}, locale));
                redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
                return new ModelAndView("redirect:/account/pagination.htm");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("给授权User[" + command.getId() + "]成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/account/pagination.htm");
    }

    @RequestMapping(value = "/update_appKey.htm/{id}", method = RequestMethod.GET)
    public ModelAndView updateAppKey(@PathVariable String id, @ModelAttribute("command") UpdateUserAppKeyCommand command,
                                     RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AccountRepresentation account;
        try {
            account = accountAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/account/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/account/updateAppKey", "account", account).addObject("command", command);
    }

    @RequestMapping(value = "/update_appKey.htm", method = RequestMethod.POST)
    public ModelAndView updateAppKey(@Valid @ModelAttribute("command") UpdateUserAppKeyCommand command, BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes, Locale locale) {

        if (bindingResult.hasErrors()) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("account.appKey.NotBlank.messages", null, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/account/update_appKey.htm/{id}");
        }

        AlertMessage alertMessage;
        try {
            accountAppService.updateAppKey(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/account/update_appKey.htm/{id}");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            if (e.getMessage().indexOf("AppKey") != -1) {
                alertMessage = new AlertMessage(this.getMessage("appKey.id.not.found.messages", new Object[]{command.getAppKey()}, locale));
                redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
                redirectAttributes.addAttribute("id", command.getId());
                return new ModelAndView("redirect:/account/update_appKey.htm/{id}");
            } else {
                alertMessage = new AlertMessage(this.getMessage("account.id.not.found.messages", new Object[]{command.getId()}, locale));
                redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
                return new ModelAndView("redirect:/account/pagination.htm");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("更改User[" + command.getId() + "]AppKey成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/account/pagination.htm");
    }


    @RequestMapping(value = "/profile.htm")
    public ModelAndView profile(HttpSession session) {
        return new ModelAndView("/account/profile");
    }

    @RequestMapping(value = "/update_headPic")
    @ResponseBody
    public UploadResult updateHeadPic(@RequestParam MultipartFile file, HttpSession session, HttpServletResponse response) {
        AccountRepresentation user = (AccountRepresentation) session.getAttribute(Constants.SESSION_USER);
        if (null == user) {
            return null;
        }
        UploadResult uploadResult = null;
        try {
            MultipartFile[] files = new MultipartFile[1];
            files[0] = file;
            uploadResult = fileUploadService.imgUpload(files);
            Object[] objects = uploadResult.getFiles();

            UploadSuccess uploadSuccess = (UploadSuccess) objects[0];
            UpdateHeadPicCommand command = new UpdateHeadPicCommand();
            command.setId(user.getId());
            command.setHandPic(uploadSuccess.getUrl());

            accountAppService.updateHeadPic(command);

            user = accountAppService.searchByID(user.getId());
            session.setAttribute(Constants.SESSION_USER, user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        return uploadResult;
    }
}
