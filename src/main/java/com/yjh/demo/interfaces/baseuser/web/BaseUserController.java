package com.yjh.demo.interfaces.baseuser.web;

import com.yjh.demo.application.baseuser.IBaseUserAppService;
import com.yjh.demo.application.baseuser.command.CreateBaseUserCommand;
import com.yjh.demo.application.baseuser.command.EditBaseUserCommand;
import com.yjh.demo.application.baseuser.command.ListBaseUserCommand;
import com.yjh.demo.application.baseuser.representation.BaseUserRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.exception.ConcurrencyException;
import com.yjh.demo.core.exception.ExistException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.interfaces.shared.web.AlertMessage;
import com.yjh.demo.interfaces.shared.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

/**
 * Created by YJH on 2016/3/31.
 */
@Controller
@RequestMapping("/base_user")
public class BaseUserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.toString());

    @Autowired
    private IBaseUserAppService baseUserAppService;

    @RequestMapping(value = "/pagination.htm")
    public ModelAndView pagination(ListBaseUserCommand command) {
        return new ModelAndView("/permission/list", "pagination", baseUserAppService.pagination(command)).addObject("command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("command") CreateBaseUserCommand command) {
        return new ModelAndView("/baseUser/create", "command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("command") CreateBaseUserCommand command, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/baseUser/create");
        }
        AlertMessage alertMessage;
        BaseUserRepresentation baseUser;
        try {
            baseUser = baseUserAppService.create(command);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            if (e.getMessage().indexOf("AppKey") != -1) {
                alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                        this.getMessage("appKey.id.not.found.message", new Object[]{command.getAppKey()}, locale));
            } else {
                alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                        this.getMessage("role.id.not.found.message", new Object[]{command.getRole()}, locale));
            }
            return new ModelAndView("/baseUser/create", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (ExistException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("baseUser.userName.Exist.message", new Object[]{command.getUserName()}, locale));
            return new ModelAndView("/baseUser/create", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        logger.info("创建BaseUser[" + baseUser.getUserName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.create.success.message", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", baseUser.getId());
        return new ModelAndView("redirect:/base_user/info.htm/{id}");
    }

    @RequestMapping(value = "/info.htm/{id}")
    public ModelAndView info(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        BaseUserRepresentation baseUser;
        try {
            baseUser = baseUserAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("baseUser.id.not.found.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/base_user/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/baseUser/info", "baseUser", baseUser);
    }

    @RequestMapping(value = "/edit.htm/{id}")
    public ModelAndView edit(@PathVariable String id, @ModelAttribute("command") EditBaseUserCommand command,
                             RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        BaseUserRepresentation baseUser;
        try {
            baseUser = baseUserAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("baseUser.id.not.found.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/base_user/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/baseUser/edit", "baseUser", baseUser).addObject("command", command);
    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("command") EditBaseUserCommand command, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/baseUser/edit", "command", command);
        }
        AlertMessage alertMessage;
        BaseUserRepresentation baseUser;
        try {
            baseUser = baseUserAppService.edit(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/base_user/edit.htm/{id}");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            if (e.getMessage().indexOf("AppKey") != -1) {
                alertMessage = new AlertMessage(this.getMessage("appKey.id.not.found.message", new Object[]{command.getAppKey()}, locale));
            } else if (e.getMessage().indexOf("Role") != -1) {
                alertMessage = new AlertMessage(this.getMessage("role.id.not.found.message", new Object[]{command.getRole()}, locale));
            } else {
                alertMessage = new AlertMessage(this.getMessage("baseUser.id.not.found.message", new Object[]{command.getId()}, locale));
                redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
                return new ModelAndView("redirect:/base_user/pagination.htm");
            }
            return new ModelAndView("/baseUser/edit", "command", command).addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改BaseUser[" + baseUser.getUserName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.message", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", baseUser.getId());
        return new ModelAndView("redirect:/base_user/info.htm/{id}");
    }

    @RequestMapping(value = "/update_status")
    public ModelAndView updateStatus(SharedCommand command, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        try {
            baseUserAppService.updateStatus(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/base_user/pagination.htm");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("baseUser.id.not.found.message", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/base_user/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改BaseUser[" + command.getId() + "]状态成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.message", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/base_user/pagination.htm");
    }
}
