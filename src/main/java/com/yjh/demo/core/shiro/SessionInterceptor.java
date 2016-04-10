package com.yjh.demo.core.shiro;

import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.core.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

    private static final String[] IGNORE_URI = {"/", "/login.htm", "resources/"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            AccountRepresentation user = (AccountRepresentation) request.getSession().getAttribute(Constants.SESSION_USER);
            if (user != null) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
