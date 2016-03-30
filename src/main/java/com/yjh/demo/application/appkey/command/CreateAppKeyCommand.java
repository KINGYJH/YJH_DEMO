package com.yjh.demo.application.appkey.command;

import com.yjh.demo.core.enums.EnableStatus;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by YJH on 2016/3/30.
 */
public class CreateAppKeyCommand {

    @NotBlank(message = "{appKey.name.NotBlank.message}")
    private String name;        //应用标识名称
    @NotBlank(message = "{appKey.description.NotBlank.message}")
    private String description;    //用用标识描述
    @NotBlank(message = "{appKey.projectName.NotBlank.message}")
    private String projectName; //应用标识项目名
    @NotNull(message = "{appKey.status.NotNull.message}")
    private EnableStatus status;    //状态

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
