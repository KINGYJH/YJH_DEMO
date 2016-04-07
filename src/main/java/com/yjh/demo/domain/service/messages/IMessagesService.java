package com.yjh.demo.domain.service.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.ListHandMessagesCommand;
import com.yjh.demo.application.messages.command.ListMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.domain.mode.message.HandMessages;
import com.yjh.demo.domain.mode.message.Messages;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/4/7.
 */
public interface IMessagesService {
    Messages create(CreateMessagesCommand command);

    void updateHandMessagesStatus(UpdateHandMessageStatusCommand command);

    HandMessages searchHandMessagesByID(String id);

    Messages searchMessagesByID(String id);

    List<HandMessages> searchHandMessagesByMessagesID(String id);

    Pagination<Messages> paginationMessages(ListMessagesCommand command);

    List<HandMessages> listHandMessages(ListHandMessagesCommand command);
}
