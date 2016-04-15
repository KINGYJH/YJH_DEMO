package com.yjh.demo.application.area;

import com.yjh.demo.application.area.command.CreateAreaCommand;
import com.yjh.demo.application.area.command.EditAreaCommand;
import com.yjh.demo.application.area.command.ListAreaCommand;
import com.yjh.demo.application.area.representation.AreaRepresentation;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/4/14.
 */
public interface IAreaAppService {

    Pagination<AreaRepresentation> pagination(ListAreaCommand command);

    AreaRepresentation searchByID(String id);

    AreaRepresentation create(CreateAreaCommand command);

    AreaRepresentation edit(EditAreaCommand command);

    void updateStatus(SharedCommand command);

    List<AreaRepresentation> listJSON(ListAreaCommand command);

}
