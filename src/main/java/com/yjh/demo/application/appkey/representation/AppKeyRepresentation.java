package com.yjh.demo.application.appkey.representation;

import com.yjh.demo.core.enums.EnableStatus;

import java.util.Date;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class AppKeyRepresentation {

    private String id;
    private Integer version;
    private Date createDate;

    private String name;        //应用标识名称
    private String description;    //用用标识描述
    private String projectName; //应用标识项目名
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public void setStatus(EnableStatus status) {
        this.status = status;
    }
}
