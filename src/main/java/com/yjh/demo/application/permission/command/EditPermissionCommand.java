package com.yjh.demo.application.permission.command;

import com.yjh.demo.application.shared.command.SharedCommand;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by YJH on 2016/3/30.
 */
public class EditPermissionCommand extends SharedCommand {

    @NotBlank(message = "{permission.name.NotBlank.Messages}")
    private String name;            //权限名称
    @NotBlank(message = "{permission.description.NotBlank.Messages}")
    private String description;        //权限描述
    @NotBlank(message = "{permission.value.NotBlank.Messages}")
    private String value;           //权限默认值
    @NotBlank(message = "{permission.appKey.NotBlank.Messages}")
    private String appKey;          //应用标识ID

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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
