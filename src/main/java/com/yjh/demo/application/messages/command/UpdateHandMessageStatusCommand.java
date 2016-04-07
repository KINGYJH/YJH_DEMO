package com.yjh.demo.application.messages.command;

import com.yjh.demo.application.shared.command.SharedCommand;
import com.yjh.demo.core.enums.MessageStatus;
import com.yjh.demo.core.enums.ReadStatus;

/**
 * Created by YJH on 2016/4/7.
 */
public class UpdateHandMessageStatusCommand extends SharedCommand {

    private MessageStatus sendStatus;       //发件箱中的状态
    private MessageStatus receiveStatus;     //收件箱状态
    private ReadStatus readStatus;          //阅读状态

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
