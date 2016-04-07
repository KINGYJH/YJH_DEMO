package com.yjh.demo.application.account.command;

import com.yjh.demo.application.shared.command.SharedCommand;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class AuthorizeAccountCommand extends SharedCommand {

    @NotNull(message = "{user.roles.NotNull.Messages}")
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
