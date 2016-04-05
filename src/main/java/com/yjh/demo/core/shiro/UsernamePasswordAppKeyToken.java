package com.yjh.demo.core.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class UsernamePasswordAppKeyToken extends UsernamePasswordToken {

    private String appKey;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public UsernamePasswordAppKeyToken() {
        super();
    }

    public UsernamePasswordAppKeyToken(String username, String password, String appKey) {
        super(username, password);
        this.appKey = appKey;
    }
}
