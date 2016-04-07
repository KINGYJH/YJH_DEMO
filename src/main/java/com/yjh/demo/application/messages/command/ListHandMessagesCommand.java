package com.yjh.demo.application.messages.command;

import com.yjh.demo.core.enums.MessageStatus;
import com.yjh.demo.core.enums.ReadStatus;

/**
 * Created by YJH on 2016/4/7 0007.
 */
public class ListHandMessagesCommand {

    private String sendAccount;
    private String receiveAccount;
    private String messages;                //信息
    private MessageStatus sendStatus;       //发件箱中的状态
    private MessageStatus receiveStatus;     //收件箱状态
    private ReadStatus readStatus;          //阅读状态

    public String getSendAccount() {
        return sendAccount;
    }

    public void setSendAccount(String sendAccount) {
        this.sendAccount = sendAccount;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
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
