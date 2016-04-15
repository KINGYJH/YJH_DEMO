package com.yjh.demo.domain.service.area;

import com.yjh.demo.application.area.command.CreateAreaCommand;
import com.yjh.demo.application.area.command.EditAreaCommand;
import com.yjh.demo.application.area.command.ListAreaCommand;
import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.domain.mode.area.Area;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;


/**
 * Created by YJH on 2016/4/14.
 */
public interface IAreaService {

    Pagination<Area> pagination(ListAreaCommand command);

    Area searchByID(String id);

    Area create(CreateAreaCommand command);

    Area edit(EditAreaCommand command);

    void updateStatus(SharedCommand command);

    List<Area> list(ListAreaCommand command);
}
