package com.yjh.demo.infrastructure.persistence.hibernate.messages;

import com.yjh.demo.domain.mode.message.HandMessages;
import com.yjh.demo.domain.mode.message.IHandMessagesRepository;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/4/7.
 */
@Repository("handMessagesRepository")
public class HandMessagesRepository extends AbstractHibernateGenericRepository<HandMessages, String>
        implements IHandMessagesRepository<HandMessages, String> {
}
