package com.yjh.demo.core.enums;

/**
 * Created by YJH on 2016/3/2.
 */
public enum EnableStatus {

    ENABLE("启用", 0, Boolean.FALSE),
    DISABLE("禁用", 1, Boolean.FALSE);

    private EnableStatus(String name, int value, Boolean onlyQuery) {
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
