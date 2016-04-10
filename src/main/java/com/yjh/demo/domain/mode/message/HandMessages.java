package com.yjh.demo.domain.mode.message;

import com.yjh.demo.core.enums.MessageStatus;
import com.yjh.demo.core.enums.ReadStatus;
import com.yjh.demo.core.id.ConcurrencySafeEntity;
import com.yjh.demo.domain.mode.account.Account;

import java.util.Date;

/**
 * Created by YJH on 2016/4/7.
 */
public class HandMessages extends ConcurrencySafeEntity {

    private Account senderAccount;          //发送人
    private Account receiveAccount;         //收信人
    private Messages messages;                //信息
    private MessageStatus sendStatus;       //发件箱中的状态
    private MessageStatus receiveStatus;     //收件箱状态
    private ReadStatus readStatus;          //阅读状态

    public void changeSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public void changeReceiveAccount(Account receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public void changeMessage(Messages messages) {
        this.messages = messages;
    }

    public void changeSendStatus(MessageStatus sendStatus) {
        this.sendStatus = sendStatus;
    }

    public void changeReceiveStatus(MessageStatus receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public void changeReadStatus(ReadStatus readStatus) {
        this.readStatus = readStatus;
    }

    private void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    private void setReceiveAccount(Account receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    private void setMessages(Messages messages) {
        this.messages = messages;
    }

    private void setSendStatus(MessageStatus sendStatus) {
        this.sendStatus = sendStatus;
    }

    private void setReceiveStatus(MessageStatus receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    private void setReadStatus(ReadStatus readStatus) {
        this.readStatus = readStatus;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public Account getReceiveAccount() {
        return receiveAccount;
    }

    public Messages getMessages() {
        return messages;
    }

    public MessageStatus getSendStatus() {
        return sendStatus;
    }

    public MessageStatus getReceiveStatus() {
        return receiveStatus;
    }

    public ReadStatus getReadStatus() {
        return readStatus;
    }

    public HandMessages() {
        super();
    }

    public HandMessages(Account senderAccount, Account receiveAccount, Messages messages, MessageStatus sendStatus, MessageStatus receiveStatus, ReadStatus readStatus) {
        this.senderAccount = senderAccount;
        this.receiveAccount = receiveAccount;
        this.messages = messages;
        this.sendStatus = sendStatus;
        this.receiveStatus = receiveStatus;
        this.readStatus = readStatus;
        this.setCreateDate(new Date());
    }
}
