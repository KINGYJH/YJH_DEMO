package com.yjh.demo.application.messages.representation;

import java.util.Date;
import java.util.List;

/**
 * Created by YJH on 2016/4/7 0007.
 */
public class MessagesInfoRepresentation {

    private String id;
    private Integer version;
    private Date updateDate;

    private String title;   //标题
    private String content; //内容
    private Date sendDate;  //发送时间
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public List<HandMessagesRepresentation> getHandMessagesList() {
        return handMessagesList;
    }

    public void setHandMessagesList(List<HandMessagesRepresentation> handMessagesList) {
        this.handMessagesList = handMessagesList;
    }
}
