package com.yjh.demo.application.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.ListMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.application.messages.representation.HandMessagesRepresentation;
import com.yjh.demo.application.messages.representation.MessagesInfoRepresentation;
import com.yjh.demo.application.messages.representation.MessagesRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.mode.message.HandMessages;
import com.yjh.demo.domain.mode.message.Messages;
import com.yjh.demo.domain.service.messages.IMessagesService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YJH on 2016/4/7.
 */
@Service("handMessagesAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class MessagesAppService implements IMessagesAppService {

    @Autowired
    private IMessagesService messagesService;

    @Autowired
    private IMappingService mappingService;

    @Override
    public MessagesRepresentation create(CreateMessagesCommand command) {
        return mappingService.map(messagesService.create(command), MessagesRepresentation.class, false);
    }

    @Override
    public void updateHandMessagesStatus(UpdateHandMessageStatusCommand command) {
        messagesService.updateHandMessagesStatus(command);
    }

    @Override
    @Transactional(readOnly = true)
    public MessagesInfoRepresentation searchByID(String id) {
        MessagesInfoRepresentation messages = mappingService.map(messagesService.searchMessagesByID(id), MessagesInfoRepresentation.class, false);
        List<HandMessagesRepresentation> handMessagesList = mappingService.mapAsList(messagesService.searchHandMessagesByMessagesID(id), HandMessagesRepresentation.class);
        messages.setHandMessagesList(handMessagesList);
        return messages;
    }

    @Override
    @Transactional(readOnly = true)
    public Pagination<HandMessagesRepresentation> pagination(ListMessagesCommand command) {
        command.verifyPage();
        command.verifyPageSize(15);
        Pagination<HandMessages> pagination = messagesService.paginationHandMessages(command);
        List<HandMessagesRepresentation> data = mappingService.mapAsList(pagination.getData(), HandMessagesRepresentation.class);
        return new Pagination<HandMessagesRepresentation>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

}
