package com.yjh.demo.application.permission;

import com.yjh.demo.application.permission.command.CreatePermissionCommand;
import com.yjh.demo.application.permission.command.EditPermissionCommand;
import com.yjh.demo.application.permission.command.ListPermissionCommand;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IPermissionAppService {

    Pagination<PermissionRepresentation> pagination(ListPermissionCommand command);

    Pagination<PermissionRepresentation> paginationJSON(ListPermissionCommand command);

    List<PermissionRepresentation> list(ListPermissionCommand command);

    PermissionRepresentation searchByID(String id);

    PermissionRepresentation searchByName(String name, String appKey);

    PermissionRepresentation create(CreatePermissionCommand command);

    PermissionRepresentation edit(EditPermissionCommand command);

    void updateStatus(SharedCommand command);

}
