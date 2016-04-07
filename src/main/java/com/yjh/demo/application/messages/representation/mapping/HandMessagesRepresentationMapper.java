package com.yjh.demo.application.messages.representation.mapping;

import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.application.messages.representation.HandMessagesRepresentation;
import com.yjh.demo.application.messages.representation.MessagesRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.message.HandMessages;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/4/7.
 */
@Component
public class HandMessagesRepresentationMapper extends CustomMapper<HandMessages, HandMessagesRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(HandMessages handMessages, HandMessagesRepresentation representation, MappingContext context) {
        if (null != handMessages.getSenderAccount()) {
            AccountRepresentation data = mappingService.map(handMessages.getSenderAccount(), AccountRepresentation.class, false);
            representation.setSenderAccount(data);
        }
        if (null != handMessages.getReceiveAccount()) {
            AccountRepresentation data = mappingService.map(handMessages.getReceiveAccount(), AccountRepresentation.class, false);
            representation.setReceiveAccount(data);
        }
        if (null != handMessages.getMessages()) {
            MessagesRepresentation date = mappingService.map(handMessages.getMessages(), MessagesRepresentation.class, false);
            representation.setMessages(date);
        }
    }

}
