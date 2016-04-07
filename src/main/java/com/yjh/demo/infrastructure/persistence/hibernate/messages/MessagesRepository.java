package com.yjh.demo.infrastructure.persistence.hibernate.messages;

import com.yjh.demo.domain.mode.message.IMessagesRepository;
import com.yjh.demo.domain.mode.message.Messages;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/4/7.
 */
@Repository("messagesRepository")
public class MessagesRepository extends AbstractHibernateGenericRepository<Messages, String>
        implements IMessagesRepository<Messages, String> {
}
