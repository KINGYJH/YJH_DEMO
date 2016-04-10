package com.yjh.demo.application.account.command;

import com.yjh.demo.application.shared.command.SharedCommand;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class ResetPasswordCommand extends SharedCommand {

    @NotBlank(message = "{user.password.NotBlank.messages}")
    private String password;

    @NotBlank(message = "{user.confirmPassword.NotBlank.messages}")
    private String confirmPassword; //确认密码

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
}
