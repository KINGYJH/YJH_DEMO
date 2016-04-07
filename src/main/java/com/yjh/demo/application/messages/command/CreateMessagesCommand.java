package com.yjh.demo.application.messages.command;

import java.util.List;

/**
 * Created by YJH on 2016/4/7.
 */
public class CreateMessagesCommand {

    private List<String> roles;
    private List<String> receiveAccounts;
    private String title;
    private String content;
    private String sendAccount;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getReceiveAccounts() {
        return receiveAccounts;
    }

    public void setReceiveAccounts(List<String> receiveAccounts) {
        this.receiveAccounts = receiveAccounts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendAccount() {
        return sendAccount;
    }

    public void setSendAccount(String sendAccount) {
        this.sendAccount = sendAccount;
    }
}
