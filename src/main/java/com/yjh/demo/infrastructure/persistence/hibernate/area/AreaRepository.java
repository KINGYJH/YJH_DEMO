package com.yjh.demo.infrastructure.persistence.hibernate.area;

import com.yjh.demo.domain.mode.area.Area;
import com.yjh.demo.domain.mode.area.IAreaRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/4/14.
 */
@Repository("areaRepository")
public class AreaRepository extends AbstractHibernateGenericRepository<Area, String>
        implements IAreaRepository<Area, String> {
}
