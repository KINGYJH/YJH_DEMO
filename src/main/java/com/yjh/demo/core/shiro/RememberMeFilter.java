package com.yjh.demo.core.shiro;

import com.yjh.demo.application.auth.IAuthAppService;
import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.account.representation.AccountRepresentation;
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
                        AccountRepresentation user = authAppService.login(command);
                        session = request.getSession(false);
                        session.setAttribute(globalConfig.getSessionUser(), user);
                        CoreHttpUtils.writeCookie(command, request, response, globalConfig);
                    } catch (ExcessiveAttemptsException e) {
                        CoreHttpUtils.clearCookie(request, response, globalConfig);
                        response.sendRedirect("/");
                    }
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
