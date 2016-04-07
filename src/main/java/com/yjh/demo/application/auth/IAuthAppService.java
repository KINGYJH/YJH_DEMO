package com.yjh.demo.application.auth;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.application.account.representation.AccountRepresentation;

import java.util.List;

/**
 * Created by YJH on 2016/4/5.
 */
public interface IAuthAppService {
    AccountRepresentation searchByAccountName(String userName, String appKey);

    List<PermissionRepresentation> findAllPermission();

    AccountRepresentation login(LoginCommand command);
}
