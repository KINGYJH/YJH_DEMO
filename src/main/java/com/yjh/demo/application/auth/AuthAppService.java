package com.yjh.demo.application.auth;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.permission.IPermissionAppService;
import com.yjh.demo.application.permission.command.ListPermissionCommand;
import com.yjh.demo.application.permission.representation.PermissionRepresentation;
import com.yjh.demo.application.user.IUserAppService;
import com.yjh.demo.application.user.representation.UserRepresentation;
import com.yjh.demo.core.common.GlobalConfig;
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
    private IUserAppService userAppService;

    @Autowired
    private IPermissionAppService permissionAppService;

    @Autowired
    private GlobalConfig globalConfig;

    @Override
    public UserRepresentation searchByName(String userName, String appKey) {
        return userAppService.searchByName(userName, appKey);
    }

    @Override
    public List<PermissionRepresentation> findAllPermission() {
        ListPermissionCommand command = new ListPermissionCommand();
        command.setStatus(EnableStatus.ENABLE);
        command.setAppKey(globalConfig.getAppKey());
        return permissionAppService.list(command);
    }

    @Override
    public UserRepresentation login(LoginCommand command) {
        return userAppService.login(command);
    }
}
