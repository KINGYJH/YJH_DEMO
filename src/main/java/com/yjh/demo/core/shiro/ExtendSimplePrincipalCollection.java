package com.yjh.demo.core.shiro;

import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * 扩展SimplePrincipalCollection
 * Created by YJH on 2016/4/5 0005.
 */
public class ExtendSimplePrincipalCollection extends SimplePrincipalCollection {

    private String appKey;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public ExtendSimplePrincipalCollection() {
    }

    public ExtendSimplePrincipalCollection(Object principal, String realmName, String appKey) {
        super(principal, realmName);
        this.appKey = appKey;
    }

}
