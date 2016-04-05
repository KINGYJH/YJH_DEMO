package com.yjh.demo.application.user.command;

import com.yjh.demo.application.shared.command.SharedCommand;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class AuthorizeUserCommand extends SharedCommand {

    @NotNull(message = "{user.roles.NotNull.message}")
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
