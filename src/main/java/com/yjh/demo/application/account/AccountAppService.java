package com.yjh.demo.application.account;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.account.command.*;
import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.account.Account;
import com.yjh.demo.domain.service.account.IAccountService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("accountAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AccountAppService implements IAccountAppService {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IMappingService mappingService;

    @Override
    @Transactional(readOnly = true)
    public Pagination<AccountRepresentation> pagination(ListAccountCommand command) {
        command.verifyPage();
        command.verifyPageSize(15);
        Pagination<Account> pagination = accountService.pagination(command);
        List<AccountRepresentation> data = mappingService.mapAsList(pagination.getData(), AccountRepresentation.class);
        return new Pagination<AccountRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountRepresentation> list(ListAccountCommand command) {
        return mappingService.mapAsList(accountService.list(command), AccountRepresentation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountRepresentation searchByID(String id) {
        return mappingService.map(accountService.searchByID(id), AccountRepresentation.class, false);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountRepresentation searchByAccountName(String userName, String appKey) {
        return mappingService.map(accountService.searchByAccountName(userName, appKey), AccountRepresentation.class, false);
    }

    @Override
    public AccountRepresentation create(CreateAccountCommand command) {
        return mappingService.map(accountService.create(command), AccountRepresentation.class, false);
    }

    @Override
    public AccountRepresentation edit(EditAccountCommand command) {
        return mappingService.map(accountService.edit(command), AccountRepresentation.class, false);
    }

    @Override
    public void updateStatus(SharedCommand command) {
        accountService.updateStatus(command);
    }

    @Override
    public void resetPassword(ResetPasswordCommand command) {
        accountService.resetPassword(command);
    }

    @Override
    public void authorized(AuthorizeAccountCommand command) {
        accountService.authorized(command);
    }

    @Override
    public void updateAppKey(UpdateUserAppKeyCommand command) {
        accountService.updateAppKey(command);
    }

    @Override
    public AccountRepresentation login(LoginCommand command) {
        return mappingService.map(accountService.login(command), AccountRepresentation.class, false);
    }

    @Override
    public Pagination<AccountRepresentation> paginationJSON(ListAccountCommand command) {
        command.verifyPage();
        command.setUserName(command.getAccountUserName());
        Pagination<Account> pagination = accountService.pagination(command);
        List<AccountRepresentation> data = mappingService.mapAsList(pagination.getData(), AccountRepresentation.class);
        return new Pagination<AccountRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }
}
