package com.yjh.demo.core.id;

import java.io.Serializable;

/**
 * 提供一个基本的委派主键
 * Created by YJH on 2016/3/30.
 */
public class IdentifiedDomainObject implements Serializable {
    private String id;

    protected IdentifiedDomainObject() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
