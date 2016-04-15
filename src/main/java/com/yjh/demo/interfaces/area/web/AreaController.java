package com.yjh.demo.interfaces.area.web;

import com.yjh.demo.application.area.IAreaAppService;
import com.yjh.demo.application.area.command.CreateAreaCommand;
import com.yjh.demo.application.area.command.EditAreaCommand;
import com.yjh.demo.application.area.command.ListAreaCommand;
import com.yjh.demo.application.area.representation.AreaRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.exception.ConcurrencyException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.interfaces.shared.web.AlertMessage;
import com.yjh.demo.interfaces.shared.web.BaseController;
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
 * Created by YJH on 2016/4/14.
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IAreaAppService areaAppService;

    @RequestMapping(value = "/pagination.htm")
    public ModelAndView pagination(ListAreaCommand command) {
        return new ModelAndView("/area/list", "pagination", areaAppService.pagination(command))
                .addObject("command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("command") CreateAreaCommand command) {
        return new ModelAndView("/area/create", "command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("command") CreateAreaCommand command, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/area/create", "command", command);
        }
        AlertMessage alertMessage;
        AreaRepresentation area;
        try {
            area = areaAppService.create(command);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("area.id.not.found.messages", new Object[]{command.getParent()}, locale));
            return new ModelAndView("/role/create", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("创建Area[" + area.getName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.create.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", area.getId());
        return new ModelAndView("redirect:/area/info.htm/{id}");
    }

    @RequestMapping(value = "/info.htm/{id}")
    public ModelAndView info(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AreaRepresentation area;
        try {
            area = areaAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("area.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/area/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/area/info", "area", area);
    }

    @RequestMapping(value = "/edit.htm/{id}")
    public ModelAndView edit(@PathVariable String id, @ModelAttribute("command") EditAreaCommand command,
                             RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        AreaRepresentation area;
        try {
            area = areaAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("area.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/area/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/area/edit", "area", area).addObject("command", command);
    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("command") EditAreaCommand command, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/role/edit", "command", command);
        }
        AlertMessage alertMessage;
        AreaRepresentation area;
        try {
            area = areaAppService.edit(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getName()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/area/edit.htm/{id}");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("area.id.not.found.messages", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/area/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改Area[" + area.getName() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", area.getId());
        return new ModelAndView("redirect:/area/info.htm/{id}");
    }

    @RequestMapping(value = "/update_status")
    public ModelAndView updateStatus(SharedCommand command, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        try {
            areaAppService.updateStatus(command);
        } catch (ConcurrencyException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("default.optimistic.locking.failure", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            redirectAttributes.addAttribute("id", command.getId());
            return new ModelAndView("redirect:/area/pagination.htm");
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(this.getMessage("area.id.not.found.messages", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/area/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        logger.info("修改Area[" + command.getId() + "]状态成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.edit.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/area/pagination.htm");
    }

    @RequestMapping(value = "/search")
    @ResponseBody
    public List<AreaRepresentation> search(@RequestBody ListAreaCommand command) {
        return areaAppService.listJSON(command);
    }

}
