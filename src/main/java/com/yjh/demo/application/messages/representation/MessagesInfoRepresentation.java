package com.yjh.demo.application.messages.representation;

import com.yjh.demo.application.account.representation.AccountRepresentation;

import java.util.Date;
import java.util.List;

/**
 * Created by YJH on 2016/4/7 0007.
 */
public class MessagesInfoRepresentation {

    private String id;
    private Integer version;
    private Date createDate;

    private String title;   //标题
    private String content; //内容
    private Date sendDate;  //发送时间
    private AccountRepresentation senderAccount;          //发送人
    private List<HandMessagesRepresentation> handMessagesList;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public AccountRepresentation getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(AccountRepresentation senderAccount) {
        this.senderAccount = senderAccount;
    }

    public List<HandMessagesRepresentation> getHandMessagesList() {
        return handMessagesList;
    }

    public void setHandMessagesList(List<HandMessagesRepresentation> handMessagesList) {
        this.handMessagesList = handMessagesList;
    }
}
