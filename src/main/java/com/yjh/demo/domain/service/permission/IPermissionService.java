package com.yjh.demo.domain.service.permission;

import com.yjh.demo.application.permission.command.CreatePermissionCommand;
import com.yjh.demo.application.permission.command.EditPermissionCommand;
import com.yjh.demo.application.permission.command.ListPermissionCommand;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.domain.mode.permission.Permission;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IPermissionService {

    Pagination<Permission> pagination(ListPermissionCommand command);

    List<Permission> list(ListPermissionCommand command);

    List<Permission> searchByIDs(List<String> ids);

    Permission searchByID(String id);

    Permission searchByName(String name, String appKey);

    Permission create(CreatePermissionCommand command);

    Permission edit(EditPermissionCommand command);

    void updateStatus(SharedCommand command);
}
