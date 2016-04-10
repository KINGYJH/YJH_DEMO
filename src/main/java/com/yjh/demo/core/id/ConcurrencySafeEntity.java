package com.yjh.demo.core.id;

import com.yjh.demo.core.exception.ConcurrencyException;

import java.util.Date;

/**
 * Created by YJH on 2016/3/2.
 */
public class ConcurrencySafeEntity extends Entity {

    private Integer version;

    private Date createDate;    //数据更新时间

    protected ConcurrencySafeEntity() {
        super();
    }

    public Integer getVersion() {
        return version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    protected void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void fainWhenConcurrencyViolation(Integer version) {
        if (!version.equals(this.getVersion())) {
            throw new ConcurrencyException("记录在提交之前已发生改变[id=" + this.getId() + "],请重新提交.");
        }
    }
}
