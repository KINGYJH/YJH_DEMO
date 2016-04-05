package com.yjh.demo.core.shiro;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

/**
 * 扩展SimpleAuthenticationInfo
 * Created by YJH on 2016/4/5 0005.
 */
public class ExtendSimpleAuthenticationInfo extends SimpleAuthenticationInfo {

    private String appKey;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public ExtendSimpleAuthenticationInfo() {
        super();
    }

    public ExtendSimpleAuthenticationInfo(Object principal, Object hashedCredentials, ByteSource credentialsSalt, String realmName, String appKey) {
        this.principals = new ExtendSimplePrincipalCollection(principal, realmName, appKey);
        this.credentials = hashedCredentials;
        this.credentialsSalt = credentialsSalt;
        this.appKey = appKey;
    }

}
