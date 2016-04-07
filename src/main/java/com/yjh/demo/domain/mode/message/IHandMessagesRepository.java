package com.yjh.demo.domain.mode.message;

import com.yjh.demo.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by YJH on 2016/4/7.
 */
public interface IHandMessagesRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
