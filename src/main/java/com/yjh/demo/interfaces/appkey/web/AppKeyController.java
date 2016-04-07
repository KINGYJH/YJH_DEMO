package com.yjh.demo.interfaces.appkey.web;

import com.yjh.demo.application.appkey.IAppKeyAppService;
import com.yjh.demo.application.appkey.command.CreateAppKeyCommand;
import com.yjh.demo.application.appkey.command.EditAppKeyCommand;
import com.yjh.demo.application.appkey.command.ListAppKeyCommand;
import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.exception.ConcurrencyException;
import com.yjh.demo.core.exception.ExistException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import com.yjh.demo.interfaces.shared.web.AlertMessage;
import com.yjh.demo.interfaces.shared.web.BaseController;
import com.yjh.demo.interfaces.shared.web.JsonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by YJH on 2016/3/31.
 */
@Controller
@RequestMapping("/app_key")
public class AppKeyController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IAppKeyAppService appKeyAppService;

    @RequestMapping(value = "/pagination.htm")
    public ModelAndView pagination(ListAppKeyCommand command) {
        return new ModelAndView("/appKey/list", "pagination", appKeyAppService.pagination(command)).addObject("command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("command") CreateAppKeyCommand command) {
        return new ModelAndView("/appKey/create", "command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("command") CreateAppKeyCommand command, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/appKey/create", "command", command);
        }
        AlertMessage alertMessage;
        AppKeyRepresentation appKey;
        try {
            appKey = appKeyAppService.create(command);
        } catch (ExistException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("appKey.name.Exist.messages", new Object[]{command.getName()}, locale));
            return new ModelAndView("/appKey/create", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("创建AppKey[" + appKey.getName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.create.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", appKey.getId());
        return new ModelAndView("redirect:/app_key/info.htm/{id}");
    }

    @RequestMapping(value = "/info.htm/{id}")
    public ModelAndView info(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AppKeyRepresentation appKey;
        try {
            appKey = appKeyAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("appKey.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/app_key/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/appKey/info", "appKey", appKey);
    }

    @RequestMapping(value = "/edit.htm/{id}")
    public ModelAndView edit(@PathVariable String id, @ModelAttribute("command") EditAppKeyCommand command,
                             RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AppKeyRepresentation appKey;
        try {
            appKey = appKeyAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("appKey.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/app_key/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/appKey/edit", "appKey", appKey).addObject("command", command);
    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("command") EditAppKeyCommand command, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/appKey/edit", "command", command);
        }
        AlertMessage alertMessage;
        AppKeyRepresentation appKey;
        try {
            appKey = appKeyAppService.edit(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getName()}, locale));
            return new ModelAndView("/appKey/edit", "command", command).addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (ExistException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("appKey.name.Exist.messages", new Object[]{command.getName()}, locale));
            return new ModelAndView("/appKey/edit", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("appKey.id.not.found.messages", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/app_key/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改AppKey[" + appKey.getName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", appKey.getId());
        return new ModelAndView("redirect:/app_key/info.htm/{id}");
    }

    @RequestMapping(value = "/update_status")
    public ModelAndView updateStatus(SharedCommand command, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        try {
            appKeyAppService.updateStatus(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/app_key/pagination.htm");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("appKey.id.not.found.messages", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/app_key/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改AppKey[" + command.getId() + "]状态成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/app_key/pagination.htm");
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Pagination<AppKeyRepresentation> list(@RequestBody ListAppKeyCommand command) {
        return appKeyAppService.paginationJSON(command);
    }

    @RequestMapping(value = "/all_list")
    @ResponseBody
    public JsonMessage allList() {
        JsonMessage jsonMessage = new JsonMessage();
        try {
            List<AppKeyRepresentation> data = appKeyAppService.allList();
            jsonMessage.setData(data);
            jsonMessage.setCode("200");
            jsonMessage.setMessage("查询成功");
        } catch (Exception e) {
            jsonMessage.setCode("500");
            jsonMessage.setMessage("查询失败");
        }
        return jsonMessage;
    }
}
