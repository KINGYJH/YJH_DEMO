package com.yjh.demo.application.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.ListMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.application.messages.representation.HandMessagesRepresentation;
import com.yjh.demo.application.messages.representation.MessagesInfoRepresentation;
import com.yjh.demo.application.messages.representation.MessagesRepresentation;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

/**
 * Created by YJH on 2016/4/7.
 */
public interface IMessagesAppService {

    MessagesRepresentation create(CreateMessagesCommand command);

    void updateHandMessagesStatus(UpdateHandMessageStatusCommand command);

    MessagesInfoRepresentation searchByID(String id);

    Pagination<HandMessagesRepresentation> pagination(ListMessagesCommand command);
}
