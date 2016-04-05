package com.yjh.demo.core.shiro;

import com.yjh.demo.application.user.representation.UserRepresentation;
import com.yjh.demo.core.common.GlobalConfig;
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

    @Autowired
    private GlobalConfig globalConfig;

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
            UserRepresentation user = (UserRepresentation) request.getSession().getAttribute(globalConfig.getSessionUser());
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
