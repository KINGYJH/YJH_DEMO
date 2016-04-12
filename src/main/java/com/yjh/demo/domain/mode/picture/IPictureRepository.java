package com.yjh.demo.domain.mode.picture;

import com.yjh.demo.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by YJH on 2016/4/12.
 */
public interface IPictureRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
