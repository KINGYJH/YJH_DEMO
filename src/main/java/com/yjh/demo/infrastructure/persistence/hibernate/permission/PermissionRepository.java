package com.yjh.demo.infrastructure.persistence.hibernate.permission;

import com.yjh.demo.domain.mode.permission.IPermissionRepository;
import com.yjh.demo.domain.mode.permission.Permission;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/30.
 */
@Repository("permissionRepository")
public class PermissionRepository extends AbstractHibernateGenericRepository<Permission, String>
        implements IPermissionRepository<Permission, String> {
    @Override
    public Permission searchByName(String name, String appKey) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("appKey.name", appKey));
        criteria.createAlias("appKey", "appKey");
        return (Permission) criteria.uniqueResult();
    }
}
