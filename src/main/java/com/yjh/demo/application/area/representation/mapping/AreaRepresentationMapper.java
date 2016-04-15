package com.yjh.demo.application.area.representation.mapping;

import com.yjh.demo.application.area.representation.AreaRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.area.Area;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/4/14.
 */
@Component
public class AreaRepresentationMapper extends CustomMapper<Area, AreaRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(Area area, AreaRepresentation representation, MappingContext context) {
        if (null != area.getParent()) {
            AreaRepresentation data = mappingService.map(area.getParent(), AreaRepresentation.class, false);
            representation.setParent(data);
        }
    }

}
