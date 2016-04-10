package com.yjh.demo.application.account.command;

import com.yjh.demo.application.shared.command.SharedCommand;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by YJH on 2016/4/5.
 */
public class UpdateUserAppKeyCommand extends SharedCommand {

    @NotBlank(message = "{user.appKey.NotBlank.messages}")
    private String appKey;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
