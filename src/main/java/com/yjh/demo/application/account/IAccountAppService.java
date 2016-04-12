package com.yjh.demo.application.account;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.account.command.*;
import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IAccountAppService {

    Pagination<AccountRepresentation> pagination(ListAccountCommand command);

    List<AccountRepresentation> list(ListAccountCommand command);

    AccountRepresentation searchByID(String id);

    AccountRepresentation searchByAccountName(String userName, String appKey);

    AccountRepresentation create(CreateAccountCommand command);

    AccountRepresentation edit(EditAccountCommand command);

    void updateStatus(SharedCommand command);

    void resetPassword(ResetPasswordCommand command);

    void authorized(AuthorizeAccountCommand command);

    void updateAppKey(UpdateUserAppKeyCommand command);

    AccountRepresentation login(LoginCommand command);

    Pagination<AccountRepresentation> paginationJSON(ListAccountCommand command);

    void updateHeadPic(UpdateHeadPicCommand command);
}
