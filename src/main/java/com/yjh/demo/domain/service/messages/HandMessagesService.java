package com.yjh.demo.domain.service.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.core.enums.MessageStatus;
import com.yjh.demo.core.enums.ReadStatus;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.domain.mode.account.Account;
import com.yjh.demo.domain.mode.message.HandMessages;
import com.yjh.demo.domain.mode.message.IHandMessagesRepository;
import com.yjh.demo.domain.mode.message.Messages;
import com.yjh.demo.domain.mode.role.Role;
import com.yjh.demo.domain.service.account.IAccountService;
import com.yjh.demo.domain.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by YJH on 2016/4/7.
 */
@Service("handMessagesService")
public class HandMessagesService implements IHandMessagesService {

    @Autowired
    private IHandMessagesRepository<HandMessages, String> handMessagesRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAccountService accountService;

    @Override
    public void create(CreateMessagesCommand command) {
        Account sendAccount = accountService.searchByID(command.getSendAccount());
        Messages messages = new Messages(command.getTitle(), command.getContent(), new Date());
        if (null != command.getRoles() && command.getRoles().size() > 0) {
            List<Account> accountList = accountService.searchByRoleIDs(command.getRoles());
            for (Account item : accountList) {
                HandMessages handMessages = new HandMessages(sendAccount, item, messages, MessageStatus.ORDINARY,
                        MessageStatus.ORDINARY, ReadStatus.UNREAD);
                handMessagesRepository.save(handMessages);
            }
        } else if (null != command.getReceiveAccounts() && command.getReceiveAccounts().size() > 0) {
            List<Account> accountList = accountService.searchByIDs(command.getReceiveAccounts());
            for (Account item : accountList) {
                HandMessages handMessages = new HandMessages(sendAccount, item, messages, MessageStatus.ORDINARY,
                        MessageStatus.ORDINARY, ReadStatus.UNREAD);
                handMessagesRepository.save(handMessages);
            }
        }
    }

    @Override
    public void updateStatus(UpdateHandMessageStatusCommand command) {
        HandMessages messages = this.searchByID(command.getId());
        if (null != command.getSendStatus()) {
            messages.changeSendStatus(command.getSendStatus());
        } else if (null != command.getReceiveStatus()) {
            messages.changeReceiveStatus(command.getReceiveStatus());
        } else if (null != command.getReadStatus()) {
            messages.changeReadStatus(command.getReadStatus());
        }
        handMessagesRepository.update(messages);
    }

    @Override
    public HandMessages searchByID(String id) {
        HandMessages handMessages = handMessagesRepository.getById(id);
        if (null == handMessages) {
            throw new NoFoundException("没有找到ID[" + id + "]的HandMessages数据");
        }
        return handMessages;
    }
}
