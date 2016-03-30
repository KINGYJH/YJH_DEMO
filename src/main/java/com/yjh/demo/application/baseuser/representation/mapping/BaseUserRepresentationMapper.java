package com.yjh.demo.application.baseuser.representation.mapping;

import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.baseuser.representation.BaseUserRepresentation;
import com.yjh.demo.application.role.representation.RoleRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.mode.baseuser.BaseUser;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by YJH on 2016/3/30 0030.
 */
public class BaseUserRepresentationMapper extends CustomMapper<BaseUser, BaseUserRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(BaseUser baseUser, BaseUserRepresentation representation, MappingContext context) {
        if (null != baseUser.getAppKey()) {
            AppKeyRepresentation data = mappingService.map(baseUser.getAppKey(), AppKeyRepresentation.class, false);
            representation.setAppKey(data);
        }
        if (null != baseUser.getRole()) {
            RoleRepresentation data = mappingService.map(baseUser.getRole(), RoleRepresentation.class, false);
            representation.setRole(data);
        }
    }

}
