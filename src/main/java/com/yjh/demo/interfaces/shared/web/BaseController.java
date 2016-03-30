package com.yjh.demo.interfaces.shared.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by YJH on 2016/3/30.
 */
public abstract class BaseController {

    @Autowired
    private MessageSource messageSource;

    private MessageSource getMessageSource() {
        return messageSource;
    }

    protected String getMessage(String code, Object[] parameterArr, Locale locale) {
        return this.getMessageSource().getMessage(code, parameterArr, locale);
    }
}
