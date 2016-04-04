package com.yjh.demo.domain.service.appkey;

import com.yjh.demo.application.appkey.command.CreateAppKeyCommand;
import com.yjh.demo.application.appkey.command.EditAppKeyCommand;
import com.yjh.demo.application.appkey.command.ListAppKeyCommand;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.exception.ExistException;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.core.util.CoreStringUtils;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.mode.appkey.IAppKeyRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("appKeyService")
public class AppKeyService implements IAppKeyService {

    @Autowired
    private IAppKeyRepository<AppKey, String> appKeyRepository;

    @Override
    public List<AppKey> list(ListAppKeyCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("updateDate"));
        return appKeyRepository.list(criterionList, orderList);
    }

    @Override
    public Pagination<AppKey> pagination(ListAppKeyCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        if (!CoreStringUtils.isEmpty(command.getName())) {
            criterionList.add(Restrictions.like("name", command.getName(), MatchMode.ANYWHERE));
        }
        if (null != command.getStatus() && command.getStatus() != EnableStatus.ALL) {
            criterionList.add(Restrictions.eq("status", command.getStatus()));
        }
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("updateDate"));
        return appKeyRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
    }

    @Override
    public AppKey searchByID(String id) {
        AppKey appKey = appKeyRepository.getById(id);
        if (null == appKey) {
            throw new NoFoundException("没有找到ID[" + id + "]的AppKey数据");
        }
        return appKey;
    }

    @Override
    public AppKey searchByName(String name) {
        return appKeyRepository.searchByName(name);
    }

    @Override
    public AppKey create(CreateAppKeyCommand command) {
        if (null != this.searchByName(command.getName())) {
            throw new ExistException("name[" + command.getName() + "]的AppKey数据已存在");
        }
        AppKey appKey = new AppKey(command.getName(), command.getDescription(),
                command.getProjectName(), command.getStatus());
        appKeyRepository.save(appKey);
        return appKey;
    }

    @Override
    public AppKey edit(EditAppKeyCommand command) {
        AppKey appKey = this.searchByID(command.getId());
        appKey.fainWhenConcurrencyViolation(command.getVersion());
        if (!appKey.getName().equals(command.getName())) {
            if (null != this.searchByName(command.getName())) {
                throw new ExistException("name[" + command.getName() + "]的AppKey数据已存在");
            }
        }
        appKey.changeName(command.getName());
        appKey.changeDescription(command.getDescription());
        appKey.changeProjectName(command.getProjectName());
        appKeyRepository.update(appKey);
        return appKey;
    }

    @Override
    public void updateStatus(SharedCommand command) {
        AppKey appKey = this.searchByID(command.getId());
        appKey.fainWhenConcurrencyViolation(command.getVersion());
        if (appKey.getStatus() == EnableStatus.DISABLE) {
            appKey.changeStatus(EnableStatus.ENABLE);
        } else {
            appKey.changeStatus(EnableStatus.DISABLE);
        }
        appKeyRepository.update(appKey);
    }
}
