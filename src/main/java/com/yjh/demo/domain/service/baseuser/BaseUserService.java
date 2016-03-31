package com.yjh.demo.domain.service.baseuser;

import com.yjh.demo.application.baseuser.command.*;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.common.PasswordHelper;
import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.exception.ExistException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.core.util.CoreStringUtils;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.mode.baseuser.BaseUser;
import com.yjh.demo.domain.mode.baseuser.IBaseUserRepository;
import com.yjh.demo.domain.mode.role.Role;
import com.yjh.demo.domain.service.appkey.IAppKeyService;
import com.yjh.demo.domain.service.role.IRoleService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("baseUserService")
public class BaseUserService implements IBaseUserService {

    @Autowired
    private IBaseUserRepository<BaseUser, String> baseUserRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAppKeyService appKeyService;

    @Override
    public Pagination<BaseUser> pagination(ListBaseUserCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("updateDate"));
        return baseUserRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
    }

    @Override
    public List<BaseUser> list(ListBaseUserCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("updateDate"));
        return baseUserRepository.list(criterionList, orderList);
    }

    @Override
    public BaseUser searchByID(String id) {
        BaseUser baseUser = baseUserRepository.getById(id);
        if (null == baseUser) {
            throw new NoFoundException("没有找到ID[" + id + "]的BaseUser数据");
        }
        return baseUser;
    }

    @Override
    public BaseUser searchByName(String userName, String appKey) {
        return baseUserRepository.searchByName(userName, appKey);
    }

    @Override
    public BaseUser create(CreateBaseUserCommand command) {
        AppKey appKey = appKeyService.searchByID(command.getAppKey());
        Role role = CoreStringUtils.isEmpty(command.getRole()) ? null : roleService.searchByID(command.getRole());
        if (null != this.searchByName(command.getUserName(), command.getAppKey())) {
            throw new ExistException("userName[" + command.getUserName() + "]的BaseUser数据已存在");
        }
        String salt = PasswordHelper.getSalt();
        String password = PasswordHelper.encryptPassword(command.getPassword(), salt);
        BaseUser baseUser = new BaseUser(command.getUserName(), password, salt, null, null, null,
                role, new Date(), appKey, command.getStatus());
        baseUserRepository.save(baseUser);
        return baseUser;
    }

    @Override
    public BaseUser edit(EditBaseUserCommand command) {
        AppKey appKey = appKeyService.searchByID(command.getAppKey());
        Role role = roleService.searchByID(command.getRole());
        BaseUser baseUser = this.searchByID(command.getId());
        baseUser.fainWhenConcurrencyViolation(command.getVersion());
        baseUser.changeAppKey(appKey);
        baseUser.changeRole(role);
        baseUser.changeStatus(command.getStatus());
        baseUserRepository.update(baseUser);
        return baseUser;
    }

    @Override
    public void updateStatus(SharedCommand command) {
        BaseUser baseUser = this.searchByID(command.getId());
        baseUser.fainWhenConcurrencyViolation(command.getVersion());
        if (baseUser.getStatus() == EnableStatus.DISABLE) {
            baseUser.changeStatus(EnableStatus.ENABLE);
        } else {
            baseUser.changeStatus(EnableStatus.DISABLE);
        }
        baseUserRepository.update(baseUser);
    }

    @Override
    public void resetPassword(ResetPasswordCommand command) {
        BaseUser baseUser = this.searchByID(command.getId());
        baseUser.fainWhenConcurrencyViolation(command.getVersion());
        String password = PasswordHelper.encryptPassword(command.getPassword(), baseUser.getSalt());
        baseUser.changePassword(password);
        baseUserRepository.update(baseUser);
    }

    @Override
    public void authorized(AuthorizedBaseUserCommand command) {
        Role role = roleService.searchByID(command.getRole());
        BaseUser baseUser = this.searchByID(command.getId());
        baseUser.fainWhenConcurrencyViolation(command.getVersion());
        baseUser.changeRole(role);
        baseUserRepository.update(baseUser);
    }
}
