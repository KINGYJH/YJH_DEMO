package com.yjh.demo.core.enums;

/**
 * Created by YJH on 2016/3/2.
 */
public enum ResourcesType {

    ALL("全部", 0, Boolean.TRUE),
    DIRECTORY("目录", 1, Boolean.FALSE),
    MENU("菜单", 2, Boolean.FALSE),
    BUTTON("按钮",3,Boolean.FALSE);

    private ResourcesType(String name, int value, Boolean onlyQuery) {
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

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean getOnlyQuery() {
        return onlyQuery;
    }

    public void setOnlyQuery(Boolean onlyQuery) {
        this.onlyQuery = onlyQuery;
    }
}
