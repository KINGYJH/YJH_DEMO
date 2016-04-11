package com.yjh.demo.core.upload;

/**
 * Created by YJH on 2016/4/11.
 */
public class UploadResult {

    private Object[] files;

    public UploadResult(Object[] files) {
        this.files = files;
    }

    public Object[] getFiles() {
        return files;
    }

    public void setFiles(Object[] files) {
        this.files = files;
    }

}
