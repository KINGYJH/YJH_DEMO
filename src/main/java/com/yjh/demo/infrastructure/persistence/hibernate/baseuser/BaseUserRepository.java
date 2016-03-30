package com.yjh.demo.infrastructure.persistence.hibernate.baseuser;

import com.yjh.demo.domain.mode.baseuser.BaseUser;
import com.yjh.demo.domain.mode.baseuser.IBaseUserRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/30.
 */
@Repository("baseUserRepository")
public class BaseUserRepository extends AbstractHibernateGenericRepository<BaseUser, String>
        implements IBaseUserRepository<BaseUser, String> {
    @Override
    public BaseUser searchByName(String userName, String appKey) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("appKey.id", appKey));
        return (BaseUser) criteria.uniqueResult();
    }
}
