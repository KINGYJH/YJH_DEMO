package com.yjh.demo.application.user;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.user.command.*;
import com.yjh.demo.application.user.representation.UserRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.user.User;
import com.yjh.demo.domain.service.user.IUserService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("userAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UserAppService implements IUserAppService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMappingService mappingService;

    @Override
    @Transactional(readOnly = true)
    public Pagination<UserRepresentation> pagination(ListUserCommand command) {
        command.verifyPage();
        command.verifyPageSize(15);
        Pagination<User> pagination = userService.pagination(command);
        List<UserRepresentation> data = mappingService.mapAsList(pagination.getData(), UserRepresentation.class);
        return new Pagination<UserRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserRepresentation> list(ListUserCommand command) {
        return mappingService.mapAsList(userService.list(command), UserRepresentation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public UserRepresentation searchByID(String id) {
        return mappingService.map(userService.searchByID(id), UserRepresentation.class, false);
    }

    @Override
    @Transactional(readOnly = true)
    public UserRepresentation searchByName(String userName, String appKey) {
        return mappingService.map(userService.searchByName(userName, appKey), UserRepresentation.class, false);
    }

    @Override
    public UserRepresentation create(CreateUserCommand command) {
        return mappingService.map(userService.create(command), UserRepresentation.class, false);
    }

    @Override
    public UserRepresentation edit(EditUserCommand command) {
        return mappingService.map(userService.edit(command), UserRepresentation.class, false);
    }

    @Override
    public void updateStatus(SharedCommand command) {
        userService.updateStatus(command);
    }

    @Override
    public void resetPassword(ResetPasswordCommand command) {
        userService.resetPassword(command);
    }

    @Override
    public void authorized(AuthorizeUserCommand command) {
        userService.authorized(command);
    }

    @Override
    public void updateAppKey(UpdateUserAppKeyCommand command) {
        userService.updateAppKey(command);
    }

    @Override
    public UserRepresentation login(LoginCommand command) {
        return mappingService.map(userService.login(command), UserRepresentation.class, false);
    }
}
