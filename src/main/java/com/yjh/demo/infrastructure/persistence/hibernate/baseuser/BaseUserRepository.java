package com.yjh.demo.infrastructure.persistence.hibernate.baseuser;

import com.yjh.demo.domain.mode.baseuser.BaseUser;
import com.yjh.demo.domain.mode.baseuser.IBaseUserRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/30.
 */
@Repository("baseUserRepository")
public class BaseUserRepository extends AbstractHibernateGenericRepository<BaseUser, String>
        implements IBaseUserRepository<BaseUser, String> {
}
