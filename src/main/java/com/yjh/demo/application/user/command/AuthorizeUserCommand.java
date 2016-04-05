package com.yjh.demo.application.user.command;

import com.yjh.demo.application.shared.command.SharedCommand;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class AuthorizeUserCommand extends SharedCommand {

    @NotBlank(message = "{user.role.NotBlank.message}")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
