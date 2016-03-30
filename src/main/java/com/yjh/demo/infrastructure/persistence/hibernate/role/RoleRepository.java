package com.yjh.demo.infrastructure.persistence.hibernate.role;

import com.yjh.demo.domain.mode.role.IRoleRepository;
import com.yjh.demo.domain.mode.role.Role;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/30.
 */
@Repository("roleRepository")
public class RoleRepository extends AbstractHibernateGenericRepository<Role, String>
        implements IRoleRepository<Role, String> {
    @Override
    public Role searchByName(String name, String appKey) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("appKey.id", appKey));
        return (Role) criteria.uniqueResult();
    }
}
