package com.yjh.demo.infrastructure.persistence.hibernate.account;

import com.yjh.demo.domain.mode.account.Account;
import com.yjh.demo.domain.mode.account.IAccountRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/30.
 */
@Repository("accountRepository")
public class AccountRepository extends AbstractHibernateGenericRepository<Account, String>
        implements IAccountRepository<Account, String> {
    @Override
    public Account searchByAccountName(String userName, String appKey) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("appKey.name", appKey));
        criteria.createAlias("appKey", "appKey");
        return (Account) criteria.uniqueResult();
    }
}
