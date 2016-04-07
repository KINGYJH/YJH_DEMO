package com.yjh.demo.domain.service.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.domain.mode.message.HandMessages;

/**
 * Created by YJH on 2016/4/7.
 */
public interface IHandMessagesService {
    void create(CreateMessagesCommand command);

    void updateStatus(UpdateHandMessageStatusCommand command);

    HandMessages searchByID(String id);
}
