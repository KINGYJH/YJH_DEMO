package com.yjh.demo.interfaces.shared.web;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by YJH on 2016/3/30.
 */
public class JsonMessage {
    private String code;
    private String message;
    private Object data;

    public JsonMessage() {
        super();
    }

    public JsonMessage(String code, String message, JSONArray data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
