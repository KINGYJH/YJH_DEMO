package com.yjh.demo.domain.service.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.ListHandMessagesCommand;
import com.yjh.demo.application.messages.command.ListMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.core.enums.MessageStatus;
import com.yjh.demo.core.enums.ReadStatus;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.core.util.CoreDateUtils;
import com.yjh.demo.core.util.CoreStringUtils;
import com.yjh.demo.domain.mode.account.Account;
import com.yjh.demo.domain.mode.message.HandMessages;
import com.yjh.demo.domain.mode.message.IHandMessagesRepository;
import com.yjh.demo.domain.mode.message.IMessagesRepository;
import com.yjh.demo.domain.mode.message.Messages;
import com.yjh.demo.domain.service.account.IAccountService;
import com.yjh.demo.domain.service.role.IRoleService;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.Pagination;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YJH on 2016/4/7.
 */
@Service("handMessagesService")
public class MessagesService implements IMessagesService {

    @Autowired
    private IHandMessagesRepository<HandMessages, String> handMessagesRepository;

    @Autowired
    private IMessagesRepository<Messages, String> messagesRepository;

    @Autowired
    private IAccountService accountService;

    @Override
    public Messages create(CreateMessagesCommand command) {
        Account sendAccount = accountService.searchByID(command.getSendAccount());
        Messages messages = new Messages(command.getTitle(), command.getContent(), new Date(), sendAccount);
        if (null != command.getRoles() && command.getRoles().size() > 0) {
            List<Account> accountList = accountService.searchByRoleIDs(command.getRoles());
            for (Account item : accountList) {
                if (!sendAccount.getId().equals(item.getId())) {
                    HandMessages handMessages = new HandMessages(sendAccount, item, messages, MessageStatus.ORDINARY,
                            MessageStatus.ORDINARY, ReadStatus.UNREAD);
                    handMessagesRepository.save(handMessages);
                }
            }
        } else if (null != command.getReceiveAccounts() && command.getReceiveAccounts().size() > 0) {
            List<Account> accountList = accountService.searchByIDs(command.getReceiveAccounts());
            for (Account item : accountList) {
                if (!sendAccount.getId().equals(item.getId())) {
                    HandMessages handMessages = new HandMessages(sendAccount, item, messages, MessageStatus.ORDINARY,
                            MessageStatus.ORDINARY, ReadStatus.UNREAD);
                    handMessagesRepository.save(handMessages);
                }
            }
        }
        messagesRepository.save(messages);
        return messages;
    }

    @Override
    public void updateHandMessagesStatus(UpdateHandMessageStatusCommand command) {
        HandMessages messages = this.searchHandMessagesByID(command.getId());
        if (null != command.getSendStatus()) {
            messages.changeSendStatus(command.getSendStatus());
        }
        if (null != command.getReceiveStatus()) {
            messages.changeReceiveStatus(command.getReceiveStatus());
        }
        if (null != command.getReadStatus()) {
            messages.changeReadStatus(command.getReadStatus());
        }
        handMessagesRepository.update(messages);
    }

    @Override
    public HandMessages searchHandMessagesByID(String id) {
        HandMessages handMessages = handMessagesRepository.getById(id);
        if (null == handMessages) {
            throw new NoFoundException("没有找到ID[" + id + "]的HandMessages数据");
        }
        return handMessages;
    }

    @Override
    public Messages searchMessagesByID(String id) {
        Messages messages = messagesRepository.getById(id);
        if (null == messages) {
            throw new NoFoundException("没有找到ID[" + id + "]的Messages数据");
        }
        return messages;
    }

    @Override
    public List<HandMessages> searchHandMessagesByMessagesID(String id) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        criterionList.add(Restrictions.eq("messages.id", id));
        return handMessagesRepository.list(criterionList, null);
    }

    @Override
    public Pagination<Messages> paginationMessages(ListMessagesCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        if (!CoreStringUtils.isEmpty(command.getSendAccount())) {
            ListHandMessagesCommand handMessagesCommand = new ListHandMessagesCommand();
            handMessagesCommand.setSendAccount(command.getSendAccount());
            List<HandMessages> handMessagesList = this.listHandMessages(handMessagesCommand);
            List<String> messagesIds = new ArrayList<String>();
            for (HandMessages item : handMessagesList) {
                messagesIds.add(item.getMessages().getId());
            }
            criterionList.add(Restrictions.in("id", messagesIds));
        }
        if (CoreStringUtils.isEmpty(command.getStartSendDateTime()) && null != CoreDateUtils.parseDate(command.getStartSendDateTime(), CoreDateUtils.DATETIME)) {
            criterionList.add(Restrictions.ge("sendDate", CoreDateUtils.parseDate(command.getStartSendDateTime(), CoreDateUtils.DATETIME)));
        }
        if (CoreStringUtils.isEmpty(command.getEndStartDateTime()) && null != CoreDateUtils.parseDate(command.getEndStartDateTime(), CoreDateUtils.DATETIME)) {
            criterionList.add(Restrictions.le("sendDate", CoreDateUtils.parseDate(command.getEndStartDateTime(), CoreDateUtils.DATETIME)));
        }

        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("sendDate"));
        return messagesRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
    }

    @Override
    public List<HandMessages> listHandMessages(ListHandMessagesCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        if (CoreStringUtils.isEmpty(command.getSendAccount())) {
            criterionList.add(Restrictions.eq("sendAccount.id", command.getSendAccount()));
        }
        if (CoreStringUtils.isEmpty(command.getReceiveAccount())) {
            criterionList.add(Restrictions.eq("receiveAccount.id", command.getReceiveAccount()));
        }
        if (null != command.getSendStatus()) {
            criterionList.add(Restrictions.eq("sendStatus", command.getSendStatus()));
        }
        if (null != command.getReceiveStatus()) {
            criterionList.add(Restrictions.eq("receiveStatus", command.getReceiveStatus()));
        }
        if (null != command.getReadStatus()) {
            criterionList.add(Restrictions.eq("readStatus", command.getReadStatus()));
        }
        return handMessagesRepository.list(criterionList, null);
    }

    @Override
    public Pagination<HandMessages> paginationHandMessages(ListMessagesCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        if (!CoreStringUtils.isEmpty(command.getReceiveAccount())) {
            criterionList.add(Restrictions.eq("receiveAccount.id", command.getReceiveAccount()));
        }
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("createDate"));
        return handMessagesRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
    }
}
