package com.yjh.demo.application.auth;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.application.user.representation.UserRepresentation;

import java.util.List;

/**
 * Created by YJH on 2016/4/5.
 */
public interface IAuthAppService {
    UserRepresentation searchByName(String userName, String appKey);

    List<PermissionRepresentation> findAllPermission();

    UserRepresentation login(LoginCommand command);
}
