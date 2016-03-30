package com.yjh.demo.domain.service.role;

import com.yjh.demo.application.role.command.CreateRoleCommand;
import com.yjh.demo.application.role.command.EditRoleCommand;
import com.yjh.demo.application.role.command.ListRoleCommand;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.exception.ExistException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.mode.permission.Permission;
import com.yjh.demo.domain.mode.role.IRoleRepository;
import com.yjh.demo.domain.mode.role.Role;
import com.yjh.demo.domain.service.appkey.IAppKeyService;
import com.yjh.demo.domain.service.permission.IPermissionService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("roleService")
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository<Role, String> roleRepository;

    @Autowired
    private IAppKeyService appKeyService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public Pagination<Role> pagination(ListRoleCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("updateDate"));
        return roleRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
    }

    @Override
    public List<Role> list(ListRoleCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("updateDate"));
        return roleRepository.list(criterionList, orderList);
    }

    @Override
    public Role searchByID(String id) {
        Role role = roleRepository.getById(id);
        if (null == role) {
            throw new NoFoundException("没有找到ID[" + id + "]的Role数据");
        }
        return role;
    }

    @Override
    public Role searchByName(String name, String appKey) {
        return roleRepository.searchByName(name, appKey);
    }

    @Override
    public Role create(CreateRoleCommand command) {
        AppKey appKey = appKeyService.searchByID(command.getAppKey());
        if (null != this.searchByName(command.getName(), appKey.getId())) {
            throw new ExistException("name[" + command.getName() + "]的Role数据已存在");
        }
        List<Permission> permissionList = permissionService.searchByIDs(command.getPermissions());
        Role role = new Role(command.getName(),
                command.getDescription(), permissionList, appKey, command.getStatus());
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role edit(EditRoleCommand command) {
        AppKey appKey = appKeyService.searchByID(command.getAppKey());
        Role role = this.searchByID(command.getId());
        role.fainWhenConcurrencyViolation(command.getVersion());
        if (!role.getName().equals(command.getName())) {
            if (null != this.searchByName(command.getName(), appKey.getId())) {
                throw new ExistException("name[" + command.getName() + "]的Role数据已存在");
            }
        }
        //循环获取权限
        List<Permission> permissionList = permissionService.searchByIDs(command.getPermissions());
        role.changeName(command.getName());
        role.changeDescription(command.getDescription());
        role.changePermissions(permissionList);
        role.changeAppKey(appKey);
        roleRepository.update(role);
        return role;
    }

    @Override
    public void updateStatus(SharedCommand command) {
        Role role = this.searchByID(command.getId());
        role.fainWhenConcurrencyViolation(command.getVersion());
        if(role.getStatus() == EnableStatus.DISABLE){
            role.changeStatus(EnableStatus.ENABLE);
        }else{
            role.changeStatus(EnableStatus.DISABLE);
        }
        roleRepository.update(role);
    }
}
