package com.yjh.demo.interfaces.auth.web;

import com.yjh.demo.application.auth.IAuthAppService;
import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.interfaces.shared.web.AlertMessage;
import com.yjh.demo.interfaces.shared.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by YJH on 2016/4/5.
 */
@Controller
public class AuthController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public IAuthAppService authAppService;

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute("command") LoginCommand command) {
        return new ModelAndView("/login", "command", command);
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("command") LoginCommand command, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, HttpServletRequest request, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/login", "command", command);
        }
        AlertMessage alertMessage;

        boolean flag = command.getVerificationCode().equals(request.getSession().getAttribute("code").toString());

        if (flag) {
            alertMessage = new AlertMessage("登录成功");
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/login.htm");
        }
        alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("Login.verificationCode.Error.message", null, locale));
        return new ModelAndView("/login", "command", command).addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
    }
}
