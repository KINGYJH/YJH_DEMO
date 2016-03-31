package com.yjh.demo.application.baseuser;

import com.yjh.demo.application.baseuser.command.*;
import com.yjh.demo.application.baseuser.representation.BaseUserRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IBaseUserAppService {

    Pagination<BaseUserRepresentation> pagination(ListBaseUserCommand command);

    List<BaseUserRepresentation> list(ListBaseUserCommand command);

    BaseUserRepresentation searchByID(String id);

    BaseUserRepresentation searchByName(String userName, String appKey);

    BaseUserRepresentation create(CreateBaseUserCommand command);

    BaseUserRepresentation edit(EditBaseUserCommand command);

    void updateStatus(SharedCommand command);

    void resetPassword(ResetPasswordCommand command);

    void authorized(AuthorizedBaseUserCommand command);

}
