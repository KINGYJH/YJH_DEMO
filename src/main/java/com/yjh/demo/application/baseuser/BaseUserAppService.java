package com.yjh.demo.application.baseuser;

import com.yjh.demo.application.baseuser.command.*;
import com.yjh.demo.application.baseuser.representation.BaseUserRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.baseuser.BaseUser;
import com.yjh.demo.domain.service.baseuser.IBaseUserService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("baseUserAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BaseUserAppService implements IBaseUserAppService {

    @Autowired
    private IBaseUserService baseUserService;

    @Autowired
    private IMappingService mappingService;

    @Override
    @Transactional(readOnly = true)
    public Pagination<BaseUserRepresentation> pagination(ListBaseUserCommand command) {
        command.verifyPage();
        command.verifyPageSize(15);
        Pagination<BaseUser> pagination = baseUserService.pagination(command);
        List<BaseUserRepresentation> data = mappingService.mapAsList(pagination.getData(), BaseUserRepresentation.class);
        return new Pagination<BaseUserRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BaseUserRepresentation> list(ListBaseUserCommand command) {
        return mappingService.mapAsList(baseUserService.list(command), BaseUserRepresentation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public BaseUserRepresentation searchByID(String id) {
        return mappingService.map(baseUserService.searchByID(id), BaseUserRepresentation.class, false);
    }

    @Override
    @Transactional(readOnly = true)
    public BaseUserRepresentation searchByName(String userName, String appKey) {
        return mappingService.map(baseUserService.searchByName(userName, appKey), BaseUserRepresentation.class, false);
    }

    @Override
    public BaseUserRepresentation create(CreateBaseUserCommand command) {
        return mappingService.map(baseUserService.create(command), BaseUserRepresentation.class, false);
    }

    @Override
    public BaseUserRepresentation edit(EditBaseUserCommand command) {
        return mappingService.map(baseUserService.edit(command), BaseUserRepresentation.class, false);
    }

    @Override
    public void upDateStatus(SharedCommand command) {
        baseUserService.upDateStatus(command);
    }

    @Override
    public void resetPassword(ResetPasswordCommand command) {
        baseUserService.resetPassword(command);
    }

    @Override
    public void authorized(AuthorizedBaseUserCommand command) {
        baseUserService.authorized(command);
    }
}
