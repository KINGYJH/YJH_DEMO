package com.yjh.demo.application.messages.command;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by YJH on 2016/4/7.
 */
public class CreateMessagesCommand {

    private List<String> roles;
    private List<String> receiveAccounts;
    @NotBlank(message = "{messages.title,NotBlank.message}")
    private String title;
    @NotBlank(message = "{messages.content,NotBlank.message}")
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
