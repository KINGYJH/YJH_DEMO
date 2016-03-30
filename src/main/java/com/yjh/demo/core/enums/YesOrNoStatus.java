package com.yjh.demo.core.enums;

/**
 * Created by YJH on 2016/3/2.
 */
public enum YesOrNoStatus {

    ALL("全部", 0, Boolean.TRUE),
    YES("是", 1, Boolean.FALSE),
    NO("否", 2, Boolean.FALSE);

    private YesOrNoStatus(String name, int value, Boolean onlyQuery) {
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
