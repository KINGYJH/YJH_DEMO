package com.yjh.demo.application.role.representation.mapping;

import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.application.role.representation.RoleRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.permission.Permission;
import com.yjh.demo.domain.mode.role.Role;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YJH on 2016/3/30 0030.
 */
@Component
public class RoleRepresentationMapper extends CustomMapper<Permission, RoleRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(Role role, RoleRepresentation representation, MappingContext context) {
        if (null != role.getAppKey()) {
            AppKeyRepresentation data = mappingService.map(role.getAppKey(), AppKeyRepresentation.class, false);
            representation.setAppKey(data);
        }
        if (null != role.getPermissions()) {
            List<PermissionRepresentation> data = mappingService.mapAsList(role.getPermissions(), PermissionRepresentation.class);
            representation.setPermissions(data);
        }
    }
}
