package com.yjh.demo.core.upload;

/**
 * Created by YJH on 2016/4/11.
 */
public class UploadFailure {

    private String name;
    private String error;

    public UploadFailure() {

    }

    public UploadFailure(String name, String error) {
        this.name = name;
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
