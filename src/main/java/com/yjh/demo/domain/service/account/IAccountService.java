package com.yjh.demo.domain.service.account;

import com.yjh.demo.application.account.command.*;
import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.domain.mode.account.Account;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IAccountService {

    Pagination<Account> pagination(ListAccountCommand command);

    List<Account> list(ListAccountCommand command);

    Account searchByID(String id);

    Account searchByAccountName(String userName, String appKey);

    Account create(CreateAccountCommand command);

    Account edit(EditAccountCommand command);

    void updateStatus(SharedCommand command);

    void resetPassword(ResetPasswordCommand command);

    void authorized(AuthorizeAccountCommand command);

    void updateAppKey(UpdateUserAppKeyCommand command);

    Account login(LoginCommand command);

    List<Account> searchByIDs(List<String> ids);

    List<Account> searchByRoleIDs(List<String> ids);
}
