package com.yjh.demo.domain.mode.message;

import com.yjh.demo.core.id.ConcurrencySafeEntity;

import java.util.Date;

/**
 * Created by YJH on 2016/4/7.
 */
public class Messages extends ConcurrencySafeEntity {

    private String title;   //标题
    private String content; //内容
    private Date sendDate;  //发送时间

    private void setTitle(String title) {
        this.title = title;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public Messages() {
        super();
    }

    public Messages(String title, String content, Date sendDate) {
        this.title = title;
        this.content = content;
        this.sendDate = sendDate;
        this.setCreateDate(new Date());
    }

}
