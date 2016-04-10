package com.yjh.demo.application.permission.command;

import com.yjh.demo.core.common.BasicPaginationCommand;
import com.yjh.demo.core.enums.EnableStatus;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public class ListPermissionCommand extends BasicPaginationCommand {

    private String name;
    private EnableStatus status;
    private String appKey;
    private String permissionName;
    private List<String> ids;

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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
