package com.yjh.demo.application.permission.representation;

import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.core.enums.EnableStatus;

import java.util.Date;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class PermissionRepresentation {

    private String id;
    private Integer version;
    private Date createDate;

    private String name;            //权限名称
    private String description;        //权限描述
    private String value;           //权限默认值
    private AppKeyRepresentation appKey;          //应用标识
    private EnableStatus status;    //状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AppKeyRepresentation getAppKey() {
        return appKey;
    }

    public void setAppKey(AppKeyRepresentation appKey) {
        this.appKey = appKey;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public void setStatus(EnableStatus status) {
        this.status = status;
    }
}
