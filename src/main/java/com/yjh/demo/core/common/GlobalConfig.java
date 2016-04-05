package com.yjh.demo.core.common;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class GlobalConfig {

    private String appKey;

    private String sessionUser;

    private String cookieUser;

    private String passwordEncryptKey;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }

    public String getCookieUser() {
        return cookieUser;
    }

    public void setCookieUser(String cookieUser) {
        this.cookieUser = cookieUser;
    }

    public String getPasswordEncryptKey() {
        return passwordEncryptKey;
    }

    public void setPasswordEncryptKey(String passwordEncryptKey) {
        this.passwordEncryptKey = passwordEncryptKey;
    }
}
