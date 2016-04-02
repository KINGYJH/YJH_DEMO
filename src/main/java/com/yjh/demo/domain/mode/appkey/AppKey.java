package com.yjh.demo.domain.mode.appkey;

import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.id.ConcurrencySafeEntity;

import java.util.Date;

/**
 * Created by YJH on 2016/3/30.
 */
public class AppKey extends ConcurrencySafeEntity {

    private String name;        //应用标识名称
    private String description;    //用用标识描述
    private String projectName; //应用标识项目名
    private EnableStatus status;    //状态

    public void changeName(String name) {
        this.name = name;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeProjectName(String projectName) {
        this.projectName = projectName;
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

    private void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getProjectName() {
        return projectName;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public AppKey() {
        super();
    }

    public AppKey(String name, String description, String projectName, EnableStatus status) {
        this.name = name;
        this.description = description;
        this.projectName = projectName;
        this.status = status;
        this.setUpdateDate(new Date());
    }
}
