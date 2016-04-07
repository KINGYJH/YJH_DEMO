package com.yjh.demo.core.enums;

/**
 * Created by YJH on 2016/4/7.
 */
public enum  MessageStatus {

    ALL("全部",0,Boolean.TRUE),
    DELETE("删除", 1, Boolean.FALSE),
    ORDINARY("普通", 2, Boolean.FALSE);

    private MessageStatus(String name, int value, Boolean onlyQuery) {
        this.name = name;
        this.value = value;
        this.onlyQuery = onlyQuery;
    }

    private String name;

    private int value;

    private Boolean onlyQuery;                  // 仅用于页面查询和业务逻辑无关

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public Boolean isOnlyQuery() {
        return onlyQuery;
    }

}
