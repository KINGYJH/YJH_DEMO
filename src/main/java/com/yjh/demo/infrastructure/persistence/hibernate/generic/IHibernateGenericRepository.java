package com.yjh.demo.infrastructure.persistence.hibernate.generic;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by YJH on 2016/3/2.
 */
public interface IHibernateGenericRepository<T, ID extends Serializable> {

    T loadById(ID id);

    T getById(ID id);

    void save(T entity);

    void saveOrUpdate(T entity);

    void update(T entity);

    void delete(T entity);

    void flush();

    void clear();

    void evict(Object obj);

    void refresh(Object obj);

    Pagination<T> pagination(int page, int pageSize, List<Criterion> criteriaList, List<Order> orderList);

    Pagination<T> pagination(int page, int pageSize, List<Criterion> criterionList, List<Order> orderList,
                             Map<String, FetchMode> fetchModeMap);

    Pagination<T> pagination(int page, int pageSize, List<Criterion> criterionList, Map<String, String> aliasMap,
                             List<Order> orderList, Map<String, FetchMode> fetchModeMap);

    List<T> findAll();

    List<T> list(List<Criterion> criteria, List<Order> orders);

    List<T> list(List<Criterion> criteria, List<Order> orders, ProjectionList projectionList,
                 Map<String, FetchMode> fetchModeMap, Map<String, String> alias);
}
