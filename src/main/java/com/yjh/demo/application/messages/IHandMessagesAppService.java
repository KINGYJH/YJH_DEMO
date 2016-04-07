package com.yjh.demo.application.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.application.messages.representation.HandMessagesRepresentation;

/**
 * Created by YJH on 2016/4/7.
 */
public interface IHandMessagesAppService {

    void create(CreateMessagesCommand command);

    void updateStatus(UpdateHandMessageStatusCommand command);

    HandMessagesRepresentation searchByID(String id);

}
