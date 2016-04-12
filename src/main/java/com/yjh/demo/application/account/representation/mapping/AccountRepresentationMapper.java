package com.yjh.demo.application.account.representation.mapping;

import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.picture.representation.PictureRepresentation;
import com.yjh.demo.application.role.representation.RoleRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.account.Account;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YJH on 2016/3/30 0030.
 */
@Component
public class AccountRepresentationMapper extends CustomMapper<Account, AccountRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(Account account, AccountRepresentation representation, MappingContext context) {
        if (null != account.getAppKey()) {
            AppKeyRepresentation data = mappingService.map(account.getAppKey(), AppKeyRepresentation.class, false);
            representation.setAppKey(data);
        }
        if (null != account.getRoles()) {
            List<RoleRepresentation> data = mappingService.mapAsList(account.getRoles(), RoleRepresentation.class);
            representation.setRoles(data);
        }
        if (null != account.getHeadPic()) {
            PictureRepresentation data = mappingService.map(account.getHeadPic(), PictureRepresentation.class, false);
            representation.setHeadPic(data);
        }
    }

}
