package com.yjh.demo.domain.service.appkey;

import com.yjh.demo.application.appkey.command.CreateAppKeyCommand;
import com.yjh.demo.application.appkey.command.EditAppKeyCommand;
import com.yjh.demo.application.appkey.command.ListAppKeyCommand;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IAppKeyService {

    List<AppKey> list(ListAppKeyCommand command);

    Pagination<AppKey> pagination(ListAppKeyCommand command);

    AppKey searchByName(String name);

    AppKey create(CreateAppKeyCommand command);

    AppKey searchByID(String id);

    AppKey edit(EditAppKeyCommand command);

    void updateStatus(SharedCommand command);
}
