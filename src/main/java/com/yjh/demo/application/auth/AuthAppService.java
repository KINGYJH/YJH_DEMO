package com.yjh.demo.application.auth;

import com.yjh.demo.application.account.IAccountAppService;
import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.permission.IPermissionAppService;
import com.yjh.demo.application.permission.command.ListPermissionCommand;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.core.common.Constants;
import com.yjh.demo.core.enums.EnableStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YJH on 2016/4/5.
 */
@Service("authAppService")
public class AuthAppService implements IAuthAppService {

    @Autowired
    private IAccountAppService accountAppService;

    @Autowired
    private IPermissionAppService permissionAppService;

    @Override
    public AccountRepresentation searchByAccountName(String userName, String appKey) {
        return accountAppService.searchByAccountName(userName, appKey);
    }

    @Override
    public List<PermissionRepresentation> findAllPermission() {
        ListPermissionCommand command = new ListPermissionCommand();
        command.setStatus(EnableStatus.ENABLE);
        command.setAppKey(Constants.APP_KRY);
        return permissionAppService.list(command);
    }

    @Override
    public AccountRepresentation login(LoginCommand command) {
        return accountAppService.login(command);
    }
}
