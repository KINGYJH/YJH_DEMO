package com.yjh.demo.application.auth.command;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by YJH on 2016/4/5.
 */
public class LoginCommand {

    @NotBlank(message = "{login.userName.NotBlank.message}")
    private String userName;
    @NotBlank(message = "{login.password.NotBlank.message}")
    private String password;
    @NotBlank(message = "{login.verificationCode.NotBlank.message}")
    private String verificationCode;
    private String rememberMe;

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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }
}
