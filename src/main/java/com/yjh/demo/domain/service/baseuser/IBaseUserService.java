package com.yjh.demo.domain.service.baseuser;

import com.yjh.demo.application.baseuser.command.*;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.domain.mode.baseuser.BaseUser;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IBaseUserService {

    Pagination<BaseUser> pagination(ListBaseUserCommand command);

    List<BaseUser> list(ListBaseUserCommand command);

    BaseUser searchByID(String id);

    BaseUser searchByName(String userName, String appKey);

    BaseUser create(CreateBaseUserCommand command);

    BaseUser edit(EditBaseUserCommand command);

    void updateStatus(SharedCommand command);

    void resetPassword(ResetPasswordCommand command);

    void authorized(AuthorizedBaseUserCommand command);
}
