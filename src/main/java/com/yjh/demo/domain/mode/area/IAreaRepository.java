package com.yjh.demo.domain.mode.area;

import com.yjh.demo.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by YJH on 2016/4/14.
 */
public interface IAreaRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
