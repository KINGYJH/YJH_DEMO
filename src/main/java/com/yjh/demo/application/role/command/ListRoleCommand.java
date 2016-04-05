package com.yjh.demo.application.role.command;

import com.yjh.demo.core.common.BasicPaginationCommand;
import com.yjh.demo.core.enums.EnableStatus;

/**
 * Created by YJH on 2016/3/30.
 */
public class ListRoleCommand extends BasicPaginationCommand {

    private String name;
    private String appKey;
    private EnableStatus status;

    private String roleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
