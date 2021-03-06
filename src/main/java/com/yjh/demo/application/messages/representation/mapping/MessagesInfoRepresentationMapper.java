package com.yjh.demo.application.messages.representation.mapping;

import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.messages.representation.MessagesInfoRepresentation;
import com.yjh.demo.application.messages.representation.MessagesRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.message.Messages;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/4/7 0007.
 */
@Component
public class MessagesInfoRepresentationMapper extends CustomMapper<Messages, MessagesInfoRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(Messages messages, MessagesInfoRepresentation representation, MappingContext context) {
        if (null != messages.getSenderAccount()) {
            AccountRepresentation data = mappingService.map(messages.getSenderAccount(), AccountRepresentation.class, false);
            representation.setSenderAccount(data);
        }
    }

}
