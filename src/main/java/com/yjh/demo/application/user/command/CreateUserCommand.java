package com.yjh.demo.application.user.command;

import com.yjh.demo.core.enums.EnableStatus;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class CreateUserCommand {

    @NotBlank(message = "{user.userName.NotBlank.message}")
    private String userName;        //用户名
    @NotBlank(message = "{user.password.NotBlank.message}")
    private String password;        //密码
    @NotBlank(message = "{user.confirmPassword.NotBlank.message}")
    private String confirmPassword; //确认密码

    private String role;            //用户角色

    @NotBlank(message = "{user.appKey.NotBlank.message}")
    private String appKey;          //应用标识
    @NotNull(message = "{user.status.NotNull.message}")
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
