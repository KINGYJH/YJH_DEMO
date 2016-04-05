package com.yjh.demo.domain.service.user;

import com.yjh.demo.application.user.command.*;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.domain.mode.user.User;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IUserService {

    Pagination<User> pagination(ListUserCommand command);

    List<User> list(ListUserCommand command);

    User searchByID(String id);

    User searchByName(String userName, String appKey);

    User create(CreateUserCommand command);

    User edit(EditUserCommand command);

    void updateStatus(SharedCommand command);

    void resetPassword(ResetPasswordCommand command);

    void authorized(AuthorizeUserCommand command);

    void updateAppKey(UpdateUserAppKeyCommand command);
}
