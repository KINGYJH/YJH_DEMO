package com.yjh.demo.infrastructure.persistence.hibernate.appkey;

import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.mode.appkey.IAppKeyRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/30.
 */
@Repository("appKeyRepository")
public class AppKeyRepository extends AbstractHibernateGenericRepository<AppKey, String>
        implements IAppKeyRepository<AppKey, String> {
    @Override
    public AppKey searchByName(String name) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("name", name));
        return (AppKey) criteria.uniqueResult();
    }
}
