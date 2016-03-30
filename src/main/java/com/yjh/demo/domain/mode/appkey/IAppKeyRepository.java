package com.yjh.demo.domain.mode.appkey;

import com.yjh.demo.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IAppKeyRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
    AppKey searchByName(String name);
}
