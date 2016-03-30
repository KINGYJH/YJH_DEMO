package com.yjh.demo.application.baseuser.command;

import com.yjh.demo.core.enums.EnableStatus;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class CreateBaseUserCommand {

    @NotBlank(message = "{baseUser.userName.NotBlank.message}")
    private String userName;        //用户名
    @NotBlank(message = "{baseUser.password.NotBlank.message}")
    private String password;        //密码

    private String role;            //用户角色

    @NotBlank(message = "{baseUser.appKey.NotBlank.message}")
    private String appKey;          //应用标识
    @NotNull(message = "{baseUser.status.NotNull.message}")
    private EnableStatus status;     //状态

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
