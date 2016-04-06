package com.yjh.demo.domain.service.user;

import com.yjh.demo.application.auth.command.LoginCommand;
import com.yjh.demo.application.user.command.*;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.common.GlobalConfig;
import com.yjh.demo.core.common.PasswordHelper;
import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.exception.ExistException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.core.shiro.UsernamePasswordAppKeyToken;
import com.yjh.demo.core.util.CoreStringUtils;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.mode.user.User;
import com.yjh.demo.domain.mode.user.IUserRepository;
import com.yjh.demo.domain.mode.role.Role;
import com.yjh.demo.domain.service.appkey.IAppKeyService;
import com.yjh.demo.domain.service.role.IRoleService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserRepository<User, String> userRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAppKeyService appKeyService;

    @Autowired
    private GlobalConfig globalConfig;

    @Override
    public Pagination<User> pagination(ListUserCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        if (!CoreStringUtils.isEmpty(command.getUserName())) {
            criterionList.add(Restrictions.like("userName", command.getUserName(), MatchMode.ANYWHERE));
        }
        if (!CoreStringUtils.isEmpty(command.getAppKey())) {
            criterionList.add(Restrictions.eq("appKey.id", command.getAppKey()));
        }
        if (null != command.getStatus() && command.getStatus() != EnableStatus.ALL) {
            criterionList.add(Restrictions.eq("status", command.getStatus()));
        }
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.asc("createDate"));
        return userRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
    }

    @Override
    public List<User> list(ListUserCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("updateDate"));
        return userRepository.list(criterionList, orderList);
    }

    @Override
    public User searchByID(String id) {
        User user = userRepository.getById(id);
        if (null == user) {
            throw new NoFoundException("没有找到ID[" + id + "]的User数据");
        }
        return user;
    }

    @Override
    public User searchByName(String userName, String appKey) {
        return userRepository.searchByName(userName, appKey);
    }

    @Override
    public User create(CreateUserCommand command) {
        AppKey appKey = appKeyService.searchByID(command.getAppKey());
        List<Role> roleList = roleService.searchByIDs(command.getRoles());
        if (null != this.searchByName(command.getUserName(), command.getAppKey())) {
            throw new ExistException("userName[" + command.getUserName() + "]的User数据已存在");
        }
        String salt = PasswordHelper.getSalt();
        String password = PasswordHelper.encryptPassword(command.getPassword(), salt);
        User user = new User(command.getUserName(), password, salt, null, null, null,
                roleList, new Date(), appKey, command.getStatus());
        userRepository.save(user);
        return user;
    }

    @Override
    public User edit(EditUserCommand command) {
        AppKey appKey = appKeyService.searchByID(command.getAppKey());
        List<Role> roleList = roleService.searchByIDs(command.getRoles());
        User user = this.searchByID(command.getId());
        user.fainWhenConcurrencyViolation(command.getVersion());
        user.changeAppKey(appKey);
        user.changeRoles(roleList);
        user.changeStatus(command.getStatus());
        userRepository.update(user);
        return user;
    }

    @Override
    public void updateStatus(SharedCommand command) {
        User user = this.searchByID(command.getId());
        user.fainWhenConcurrencyViolation(command.getVersion());
        if (user.getStatus() == EnableStatus.DISABLE) {
            user.changeStatus(EnableStatus.ENABLE);
        } else {
            user.changeStatus(EnableStatus.DISABLE);
        }
        userRepository.update(user);
    }

    @Override
    public void resetPassword(ResetPasswordCommand command) {
        User user = this.searchByID(command.getId());
        user.fainWhenConcurrencyViolation(command.getVersion());
        String password = PasswordHelper.encryptPassword(command.getPassword(), user.getSalt());
        user.changePassword(password);
        userRepository.update(user);
    }

    @Override
    public void authorized(AuthorizeUserCommand command) {
        List<Role> roleList = roleService.searchByIDs(command.getRoles());
        User user = this.searchByID(command.getId());
        user.fainWhenConcurrencyViolation(command.getVersion());
        user.changeRoles(roleList);
        userRepository.update(user);
    }

    @Override
    public void updateAppKey(UpdateUserAppKeyCommand command) {
        AppKey appKey = appKeyService.searchByID(command.getAppKey());
        User user = this.searchByID(command.getId());
        user.fainWhenConcurrencyViolation(command.getVersion());
        user.changeAppKey(appKey);
        userRepository.update(user);
    }

    @Override
    public User login(LoginCommand command) {
        User user = this.searchByName(command.getUserName(), globalConfig.getAppKey());
        if (null == user) {
            throw new UnknownAccountException();
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordAppKeyToken token = new UsernamePasswordAppKeyToken(
                command.getUserName(),
                command.getPassword(),
                globalConfig.getAppKey());
        subject.login(token);

        user.changeLastLoginIP(command.getLoginIP());
        user.changeLastLoginPlatform(command.getLoginPlatform());
        user.changeLastLoginDate(new Date());
        userRepository.update(user);

        return user;
    }
}
