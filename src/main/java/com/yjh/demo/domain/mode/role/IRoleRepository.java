package com.yjh.demo.domain.mode.role;

import com.yjh.demo.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IRoleRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
    Role searchByName(String name, String appKey);
}
