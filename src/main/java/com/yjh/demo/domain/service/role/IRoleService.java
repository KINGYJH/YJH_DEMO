package com.yjh.demo.domain.service.role;

import com.yjh.demo.application.role.command.CreateRoleCommand;
import com.yjh.demo.application.role.command.EditRoleCommand;
import com.yjh.demo.application.role.command.ListRoleCommand;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.domain.mode.role.Role;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IRoleService {

    Pagination<Role> pagination(ListRoleCommand command);

    List<Role> list(ListRoleCommand command);

    Role searchByID(String id);

    Role searchByName(String name, String appKey);

    Role create(CreateRoleCommand command);

    Role edit(EditRoleCommand command);

    void updateStatus(SharedCommand command);

    List<Role> searchByIDs(List<String> ids);
}
