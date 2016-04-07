package com.yjh.demo.interfaces.auth.web;

import com.yjh.demo.application.auth.IAuthAppService;
import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.core.common.GlobalConfig;
import com.yjh.demo.core.util.CoreHttpUtils;
import com.yjh.demo.interfaces.shared.web.AlertMessage;
import com.yjh.demo.interfaces.shared.web.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

/**
 * Created by YJH on 2016/4/5.
 */
@Controller
public class AuthController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public IAuthAppService authAppService;

    @Autowired
    private GlobalConfig globalConfig;

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute("command") LoginCommand command) {
        return new ModelAndView("/login", "command", command);
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("command") LoginCommand command, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, HttpServletRequest request,
                              HttpServletResponse response, HttpSession session, Locale locale) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/login", "command", command);
        }
        AlertMessage alertMessage;

        boolean flag = command.getVerificationCode().equals(request.getSession().getAttribute("code").toString());

        if (flag) {
            try {
                String loginIP = CoreHttpUtils.getClientIP(request);
                String loginPlatform = CoreHttpUtils.getLoginPlatform(request);
                command.setLoginIP(loginIP);
                command.setLoginPlatform(loginPlatform);
                AccountRepresentation user = authAppService.login(command);
                Subject subject = SecurityUtils.getSubject();
                if (subject.hasRole("admin") || subject.hasRole("mini-admin")) {

                    CoreHttpUtils.writeCookie(command, request, response, globalConfig);

                    logger.info(subject.getPrincipal() + "登录成功！时间:" + new Date());
                    session.setAttribute(globalConfig.getSessionUser(), user);
                    return new ModelAndView("redirect:/logged");
                } else {//用户没有对应角色 不让登录
                    alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("login.account.NotPermission.messages", null, locale));
                    redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
                    return new ModelAndView("redirect:/logout");
                }
            } catch (UnknownAccountException ue) {
                alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                        this.getMessage("login.account.NotExists.messages", null, locale));
            } catch (IncorrectCredentialsException ie) {
                alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                        this.getMessage("login.account.Error.messages", null, locale));
            } catch (LockedAccountException le) {
                alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING,
                        this.getMessage("login.account.Disable.messages", null, locale));
            } catch (Exception e) {
                alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER,
                        this.getMessage("login.login.Failure.messages", null, locale));
            }
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/login.htm");
        }
        alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("login.verificationCode.Error.messages", null, locale));
        return new ModelAndView("/login", "command", command).addObject(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        CoreHttpUtils.clearCookie(request, response, globalConfig);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/denied")
    public ModelAndView unauthorized() throws Exception {
        return new ModelAndView("/error/denied");
    }
}
