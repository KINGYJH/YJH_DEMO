package com.yjh.demo.domain.mode.baseuser;

import com.yjh.demo.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IBaseUserRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
    BaseUser searchByName(String userName, String appKey);
}
