package com.yjh.demo.application.appkey;

import com.yjh.demo.application.appkey.command.CreateAppKeyCommand;
import com.yjh.demo.application.appkey.command.EditAppKeyCommand;
import com.yjh.demo.application.appkey.command.ListAppKeyCommand;
import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.service.appkey.IAppKeyService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("appKeyAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AppKeyAppService implements IAppKeyAppService {

    @Autowired
    private IAppKeyService appKeyService;

    @Autowired
    private IMappingService mappingService;

    @Override
    @Transactional(readOnly = true)
    public List<AppKeyRepresentation> allList() {
        return mappingService.mapAsList(appKeyService.list(new ListAppKeyCommand()), AppKeyRepresentation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppKeyRepresentation> list(ListAppKeyCommand command) {
        return mappingService.mapAsList(appKeyService.list(command), AppKeyRepresentation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Pagination<AppKeyRepresentation> pagination(ListAppKeyCommand command) {
        command.verifyPage();
        command.verifyPageSize(15);
        Pagination<AppKey> pagination = appKeyService.pagination(command);
        List<AppKeyRepresentation> data = mappingService.mapAsList(pagination.getData(), AppKeyRepresentation.class);
        return new Pagination<AppKeyRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    public Pagination<AppKeyRepresentation> paginationJSON(ListAppKeyCommand command) {
        command.verifyPage();
        command.setName(command.getAppKeyName());
        Pagination<AppKey> pagination = appKeyService.pagination(command);
        List<AppKeyRepresentation> data = mappingService.mapAsList(pagination.getData(), AppKeyRepresentation.class);
        return new Pagination<AppKeyRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }


    @Override
    @Transactional(readOnly = true)
    public AppKeyRepresentation searchByID(String id) {
        return mappingService.map(appKeyService.searchByID(id), AppKeyRepresentation.class, false);
    }

    @Override
    @Transactional(readOnly = true)
    public AppKeyRepresentation searchByName(String name) {
        return mappingService.map(appKeyService.searchByName(name), AppKeyRepresentation.class, false);
    }

    @Override
    public AppKeyRepresentation create(CreateAppKeyCommand command) {
        return mappingService.map(appKeyService.create(command), AppKeyRepresentation.class, false);
    }

    @Override
    public AppKeyRepresentation edit(EditAppKeyCommand command) {
        return mappingService.map(appKeyService.edit(command), AppKeyRepresentation.class, false);
    }

    @Override
    public void updateStatus(SharedCommand command) {
        appKeyService.updateStatus(command);
    }
}
