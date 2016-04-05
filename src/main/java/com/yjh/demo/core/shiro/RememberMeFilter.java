package com.yjh.demo.core.shiro;

import com.yjh.demo.application.auth.IAuthAppService;
import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.user.representation.UserRepresentation;
import com.yjh.demo.core.common.GlobalConfig;
import com.yjh.demo.core.util.CoreHttpUtils;
import com.yjh.demo.core.util.CoreRc4Utils;
import com.yjh.demo.core.util.CoreStringUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class RememberMeFilter implements Filter {

    @Autowired
    private IAuthAppService authAppService;

    @Autowired
    private GlobalConfig globalConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();

        HttpSession session = request.getSession();
        if (null == session.getAttribute(globalConfig.getSessionUser())) {
            if (null != cookies && cookies.length > 0) {
                String cookieStr = CoreStringUtils.EMPTY;

                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(globalConfig.getCookieUser())) {
                        cookieStr = CoreRc4Utils.decry_RC4(cookie.getValue(), globalConfig.getPasswordEncryptKey());
                        break;
                    }
                }
                if (!CoreStringUtils.isEmpty(cookieStr)) {
                    String[] arr = cookieStr.split(",");
                    LoginCommand command = new LoginCommand();
                    command.setLoginIP(CoreHttpUtils.getClientIP(request));
                    command.setUserName(arr[0]);
                    command.setPassword(arr[1]);
                    command.setRememberMe(true);
                    try {
                        UserRepresentation user = authAppService.login(command);
                        session = request.getSession(false);
                        session.setAttribute(globalConfig.getSessionUser(), user);
                        writeCookie(command, request, response);
                    } catch (ExcessiveAttemptsException e) {
                        clearCookie(request, response);
                        response.sendRedirect("/");
                    }
                }
            }
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 保存用户cookie
     *
     * @param command
     * @param request
     * @param response
     */
    private void writeCookie(LoginCommand command, HttpServletRequest request, HttpServletResponse response) {
        if (command.isRememberMe()) {
            String encryptStr = command.getUserName() + "," + command.getPassword();
            Cookie cookie = new Cookie(globalConfig.getCookieUser(), CoreRc4Utils.encry_RC4_string(encryptStr, globalConfig.getPasswordEncryptKey()));
            cookie.setMaxAge(604800);
            response.addCookie(cookie);
        } else {
            clearCookie(request, response);
        }
    }

    /**
     * 移除用户保存的cookie
     *
     * @param request
     * @param response
     */
    private void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(globalConfig.getCookieUser())) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }
}
