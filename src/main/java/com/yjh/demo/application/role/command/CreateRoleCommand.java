package com.yjh.demo.application.role.command;

import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.domain.mode.appkey.AppKey;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public class CreateRoleCommand {

    @NotBlank(message = "{role.name.NotBlank.message}")
    private String name;                    //角色名称
    @NotBlank(message = "{role.description.NotBlank.message}")
    private String description;                //角色描述

    private List<String> permissions;   //角色包含的权限集合
    @NotBlank(message = "{role.appKey.NotBlank.message}")
    private String appKey;                  //应用标识
    @NotNull(message = "{role.status.NotNull.message}")
    private EnableStatus status;            //状态
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

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public void setStatus(EnableStatus status) {
        this.status = status;
    }
}
