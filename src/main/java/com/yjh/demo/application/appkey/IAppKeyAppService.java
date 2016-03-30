package com.yjh.demo.application.appkey;

import com.yjh.demo.application.appkey.command.CreateAppKeyCommand;
import com.yjh.demo.application.appkey.command.EditAppKeyCommand;
import com.yjh.demo.application.appkey.command.ListAppKeyCommand;
import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IAppKeyAppService {

    List<AppKeyRepresentation> list(ListAppKeyCommand command);

    Pagination<AppKeyRepresentation> pagination(ListAppKeyCommand command);

    AppKeyRepresentation searchByID(String id);

    AppKeyRepresentation searchByName(String name);

    AppKeyRepresentation create(CreateAppKeyCommand command);

    AppKeyRepresentation edit(EditAppKeyCommand command);

    void updateStatus(SharedCommand command);

}
