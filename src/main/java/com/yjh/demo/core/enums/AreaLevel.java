package com.yjh.demo.core.enums;

/**
 * Created by YJH on 2016/4/14.
 */
public enum AreaLevel {

    ALL("全部", 0, Boolean.TRUE),
    PROVINCE_MUNICIPALITY("省/直辖市", 1, Boolean.FALSE),
    MUNICIPAL("地级市", 2, Boolean.FALSE),
    COUNTY("区县", 3, Boolean.FALSE),
    TOWN_STREET("镇/街道", 4, Boolean.FALSE);

    private AreaLevel(String name, int value, Boolean onlyQuery) {
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
