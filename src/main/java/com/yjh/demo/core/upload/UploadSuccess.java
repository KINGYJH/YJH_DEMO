package com.yjh.demo.core.upload;

/**
 * Created by YJH on 2016/4/11.
 */
public class UploadSuccess {

    private String name;
    private long size;
    private String url;
    private String deleteUrl;

    private UploadSuccess() {

    }

    public UploadSuccess(String name, long size, String url, String deleteUrl) {
        this.name = name;
        this.size = size;
        this.url = url;
        this.deleteUrl = deleteUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }
}
