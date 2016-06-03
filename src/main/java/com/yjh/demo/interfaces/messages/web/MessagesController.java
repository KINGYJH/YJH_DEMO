package com.yjh.demo.interfaces.messages.web;

import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.messages.IMessagesAppService;
import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.ListMessagesCommand;
import com.yjh.demo.application.messages.representation.MessagesInfoRepresentation;
import com.yjh.demo.application.messages.representation.MessagesRepresentation;
import com.yjh.demo.core.common.Constants;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.core.exception.NoLoginException;
import com.yjh.demo.core.util.CoreHttpUtils;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

/**
 * Created by YJH on 2016/4/7 0007.
 */
@Controller
@RequestMapping("/messages")
public class MessagesController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IMessagesAppService messagesAppService;

    @RequestMapping(value = "/pagination.htm")
    public ModelAndView pagination(ListMessagesCommand command, HttpSession session) {
        try {
            command.setReceiveAccount(CoreHttpUtils.getSessionAccount(session).getId());
        } catch (NoLoginException e) {
            return new ModelAndView("redirect:/logout");
        }

        return new ModelAndView("/messages/list", "pagination", messagesAppService.pagination(command)).addObject("command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("command") CreateMessagesCommand command) {
        return new ModelAndView("/messages/create", "command", command);
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("command") CreateMessagesCommand command, BindingResult bindingResult,
                               HttpSession session, RedirectAttributes redirectAttributes, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/messages/create", "command", command);
        }
        AlertMessage alertMessage;
        MessagesRepresentation messages = null;
        command.setSendAccount(((AccountRepresentation) session.getAttribute(Constants.SESSION_USER)).getId());
        try {
            messages = messagesAppService.create(command);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                    this.getMessage("account.id.not.found.messages", new Object[]{command.getSendAccount()}, locale));
            return new ModelAndView("/messages/create", "command", command)
                    .addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        logger.info("创建Messages[" + messages.getTitle() + "]信息成功,时间:" + new Date());
        alertMessage = new AlertMessage(this.getMessage("default.create.success.messages", null, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        redirectAttributes.addAttribute("id", messages.getId());
        return new ModelAndView("redirect:/messages/info.htm/{id}");
    }

    @RequestMapping(value = "/info.htm/{id}")
    public ModelAndView info(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) {
        AlertMessage alertMessage;
        MessagesInfoRepresentation messages;
        try {
            messages = messagesAppService.searchByID(id);
        } catch (NoFoundException e) {
            logger.warn(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("messages.id.not.found.messages", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/messages/pagination.htm");
        } catch (Exception e) {
            logger.error(e.getMessage());
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                    this.getMessage("default.system.exception", new Object[]{e.getMessage()}, locale));
            return new ModelAndView("/error/500").addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("/messages/info", "messages", messages);
    }
}
