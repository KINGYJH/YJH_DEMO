package com.yjh.demo.application.messages.command;

import com.yjh.demo.core.common.BasicPaginationCommand;

/**
 * Created by YJH on 2016/4/7 0007.
 */
public class ListMessagesCommand extends BasicPaginationCommand {

    private String sendAccount;
    private String startSendDateTime;
    private String endStartDateTime;

    public String getSendAccount() {
        return sendAccount;
    }

    public void setSendAccount(String sendAccount) {
        this.sendAccount = sendAccount;
    }

    public String getStartSendDateTime() {
        return startSendDateTime;
    }

    public void setStartSendDateTime(String startSendDateTime) {
        this.startSendDateTime = startSendDateTime;
    }

    public String getEndStartDateTime() {
        return endStartDateTime;
    }

    public void setEndStartDateTime(String endStartDateTime) {
        this.endStartDateTime = endStartDateTime;
    }
}
