package com.yjh.demo.application.permission.representation.mapping;

import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.baseuser.BaseUser;
import com.yjh.demo.domain.mode.permission.Permission;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class PermissionRepresentationMapper extends CustomMapper<Permission, PermissionRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(Permission permission, PermissionRepresentation representation, MappingContext com) {
        if (null != permission.getAppKey()) {
            AppKeyRepresentation data = mappingService.map(permission.getAppKey(), AppKeyRepresentation.class, false);
            representation.setAppKey(data);
        }
    }

}
