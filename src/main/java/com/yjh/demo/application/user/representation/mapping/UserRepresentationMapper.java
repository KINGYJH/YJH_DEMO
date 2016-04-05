package com.yjh.demo.application.user.representation.mapping;

import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.user.representation.UserRepresentation;
import com.yjh.demo.application.role.representation.RoleRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.user.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/3/30 0030.
 */
@Component
public class UserRepresentationMapper extends CustomMapper<User, UserRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(User user, UserRepresentation representation, MappingContext context) {
        if (null != user.getAppKey()) {
            AppKeyRepresentation data = mappingService.map(user.getAppKey(), AppKeyRepresentation.class, false);
            representation.setAppKey(data);
        }
        if (null != user.getRole()) {
            RoleRepresentation data = mappingService.map(user.getRole(), RoleRepresentation.class, false);
            representation.setRole(data);
        }
    }

}
