package com.yjh.demo.domain.mode.permission;

import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.id.ConcurrencySafeEntity;
import com.yjh.demo.domain.mode.appkey.AppKey;

import java.util.Date;

/**
 * Created by YJH on 2016/3/30.
 */
public class Permission extends ConcurrencySafeEntity {

    private String name;            //权限名称
    private String description;        //权限描述
    private String value;           //权限默认值
    private AppKey appKey;          //应用标识
    private EnableStatus status;    //状态

    public void changeName(String name) {
        this.name = name;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeValue(String value) {
        this.value = value;
    }

    public void changeAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    public void changeStatus(EnableStatus status) {
        this.status = status;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setValue(String value) {
        this.value = value;
    }

    private void setAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    private void setStatus(EnableStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    public AppKey getAppKey() {
        return appKey;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public Permission() {
        super();
    }

    public Permission(String name, String description, String value, AppKey appKey,EnableStatus status) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.appKey = appKey;
        this.status = status;
        this.setUpdateDate(new Date());
    }
}
