package com.yjh.demo.application.permission;

import com.yjh.demo.application.permission.command.CreatePermissionCommand;
import com.yjh.demo.application.permission.command.EditPermissionCommand;
import com.yjh.demo.application.permission.command.ListPermissionCommand;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.core.shiro.ShiroFilterChainManager;
import com.yjh.demo.domain.mode.permission.Permission;
import com.yjh.demo.domain.service.permission.IPermissionService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("permissionAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PermissionAppService implements IPermissionAppService {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IMappingService mappingService;

    @Override
    @Transactional(readOnly = true)
    public Pagination<PermissionRepresentation> pagination(ListPermissionCommand command) {
        command.verifyPage();
        command.verifyPageSize(15);
        Pagination<Permission> pagination = permissionService.pagination(command);
        List<PermissionRepresentation> data = mappingService.mapAsList(pagination.getData(), PermissionRepresentation.class);
        return new Pagination<PermissionRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    public Pagination<PermissionRepresentation> paginationJSON(ListPermissionCommand command) {
        command.verifyPage();
        command.setName(command.getPermissionName());
        Pagination<Permission> pagination = permissionService.pagination(command);
        List<PermissionRepresentation> data = mappingService.mapAsList(pagination.getData(), PermissionRepresentation.class);
        return new Pagination<PermissionRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PermissionRepresentation> list(ListPermissionCommand command) {
        return mappingService.mapAsList(permissionService.list(command), PermissionRepresentation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PermissionRepresentation searchByID(String id) {
        return mappingService.map(permissionService.searchByID(id), PermissionRepresentation.class, false);
    }

    @Override
    @Transactional(readOnly = true)
    public PermissionRepresentation searchByName(String name, String appKey) {
        return mappingService.map(permissionService.searchByName(name, appKey), PermissionRepresentation.class, false);
    }

    @Override
    public PermissionRepresentation create(CreatePermissionCommand command) {
        return mappingService.map(permissionService.create(command), PermissionRepresentation.class, false);
    }

    @Override
    public PermissionRepresentation edit(EditPermissionCommand command) {
        return mappingService.map(permissionService.edit(command), PermissionRepresentation.class, false);
    }

    @Override
    public void updateStatus(SharedCommand command) {
        permissionService.updateStatus(command);
    }
}
