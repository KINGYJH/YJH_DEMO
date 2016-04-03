package com.yjh.demo.application.permission.command;

import com.yjh.demo.core.common.BasicPaginationCommand;
import com.yjh.demo.core.enums.EnableStatus;

/**
 * Created by YJH on 2016/3/30.
 */
public class ListPermissionCommand extends BasicPaginationCommand {

    private String name;
    private EnableStatus status;
    private String appKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public void setStatus(EnableStatus status) {
        this.status = status;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
