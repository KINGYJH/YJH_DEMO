package com.yjh.demo.application.baseuser.command;

import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.enums.EnableStatus;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class EditBaseUserCommand extends SharedCommand {

    @NotBlank(message = "{baseUser.role.NotBlank.message}")
    private String role;            //用户角色
    @NotBlank(message = "{baseUser.appKey.NotBlank.message}")
    private String appKey;          //应用标识
    @NotNull(message = "{baseUser.status.NotNull.message}")
    private EnableStatus status;     //状态

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
