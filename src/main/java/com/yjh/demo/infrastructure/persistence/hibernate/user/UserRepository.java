package com.yjh.demo.infrastructure.persistence.hibernate.user;

import com.yjh.demo.domain.mode.user.User;
import com.yjh.demo.domain.mode.user.IUserRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/30.
 */
@Repository("userRepository")
public class UserRepository extends AbstractHibernateGenericRepository<User, String>
        implements IUserRepository<User, String> {
    @Override
    public User searchByName(String userName, String appKey) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("appKey.name", appKey));
        criteria.createAlias("appKey", "appKey");
        return (User) criteria.uniqueResult();
    }
}
