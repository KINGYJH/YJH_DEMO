package com.yjh.demo.application.role;

import com.yjh.demo.application.role.command.CreateRoleCommand;
import com.yjh.demo.application.role.command.EditRoleCommand;
import com.yjh.demo.application.role.command.ListRoleCommand;
import com.yjh.demo.application.role.representation.RoleRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IRoleAppService {

    Pagination<RoleRepresentation> paginationJSON(ListRoleCommand command);

    Pagination<RoleRepresentation> pagination(ListRoleCommand command);

    List<RoleRepresentation> list(ListRoleCommand command);

    RoleRepresentation searchByID(String id);

    RoleRepresentation searchByName(String name, String appKey);

    RoleRepresentation create(CreateRoleCommand command);

    RoleRepresentation edit(EditRoleCommand command);

    void updateStatus(SharedCommand command);
}
