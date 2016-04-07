package com.yjh.demo.application.messages.representation;

import com.yjh.demo.application.account.representation.AccountRepresentation;
import com.yjh.demo.core.enums.MessageStatus;
import com.yjh.demo.core.enums.ReadStatus;

import java.util.Date;

/**
 * Created by YJH on 2016/4/7.
 */
public class HandMessagesRepresentation {

    private String id;
    private Integer version;
    private Date updateDate;

    private AccountRepresentation senderAccount;          //发送人
    private AccountRepresentation receiveAccount;         //收信人
    private MessagesRepresentation messages;                //信息
    private MessageStatus sendStatus;       //发件箱中的状态
    private MessageStatus receiveStatus;     //收件箱状态
    private ReadStatus readStatus;          //阅读状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public AccountRepresentation getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(AccountRepresentation senderAccount) {
        this.senderAccount = senderAccount;
    }

    public AccountRepresentation getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(AccountRepresentation receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public MessagesRepresentation getMessages() {
        return messages;
    }

    public void setMessages(MessagesRepresentation messages) {
        this.messages = messages;
    }

    public MessageStatus getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(MessageStatus sendStatus) {
        this.sendStatus = sendStatus;
    }

    public MessageStatus getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(MessageStatus receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public ReadStatus getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(ReadStatus readStatus) {
        this.readStatus = readStatus;
    }
}
