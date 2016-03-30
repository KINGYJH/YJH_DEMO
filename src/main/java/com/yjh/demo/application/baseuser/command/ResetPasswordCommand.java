package com.yjh.demo.application.baseuser.command;

import com.yjh.demo.application.shared.command.SharedCommand;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class ResetPasswordCommand extends SharedCommand {

    @NotBlank(message = "{baseUser.password.NotBlank.message}")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
