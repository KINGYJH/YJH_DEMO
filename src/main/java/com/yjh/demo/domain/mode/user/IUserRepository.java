package com.yjh.demo.domain.mode.user;

import com.yjh.demo.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IUserRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
    User searchByName(String userName, String appKey);
}
