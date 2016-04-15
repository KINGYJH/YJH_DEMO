package com.yjh.demo.core.upload;

import java.util.Arrays;
import java.util.List;

/**
 * 文件上传配置
 * Created by YJH on 2016/4/11.
 */
public class FileUploadConfig {

    private String path;    //上传工作路径

    private String temp;    //临时文件夹

    private long maxSize;   //最大上传大小

    private List<String> type;  //上传类型

    private String folder;       // 保存文件的目录(domainName/folder/)

    private String domainName;      //上传工作地址

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        if (!temp.endsWith("/")) {
            temp += "/";
        }
        this.temp = temp;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(String type) {
        String[] strings = type.split(",");
        this.type = Arrays.asList(strings);
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        domainName = domainName.toLowerCase();
        if (!domainName.startsWith("http://")) {
            domainName = "http://" + domainName;
        }

        if (!domainName.endsWith("/")) {
            domainName += "/";
        }
        this.domainName = domainName;
    }
}
