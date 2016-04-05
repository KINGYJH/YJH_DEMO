package com.yjh.demo.application.user;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.user.command.*;
import com.yjh.demo.application.user.representation.UserRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IUserAppService {

    Pagination<UserRepresentation> pagination(ListUserCommand command);

    List<UserRepresentation> list(ListUserCommand command);

    UserRepresentation searchByID(String id);

    UserRepresentation searchByName(String userName, String appKey);

    UserRepresentation create(CreateUserCommand command);

    UserRepresentation edit(EditUserCommand command);

    void updateStatus(SharedCommand command);

    void resetPassword(ResetPasswordCommand command);

    void authorized(AuthorizeUserCommand command);

    void updateAppKey(UpdateUserAppKeyCommand command);

    UserRepresentation login(LoginCommand command);
}
