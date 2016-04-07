package com.yjh.demo.application.account.command;

import com.yjh.demo.core.common.BasicPaginationCommand;
import com.yjh.demo.core.enums.EnableStatus;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class ListAccountCommand extends BasicPaginationCommand {

    private String userName;
    private String appKey;
    private EnableStatus status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
