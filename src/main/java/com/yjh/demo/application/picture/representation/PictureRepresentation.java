package com.yjh.demo.application.picture.representation;

import java.util.Date;

/**
 * Created by YJH on 2016/4/12 0012.
 */
public class PictureRepresentation {

    private String id;
    private Integer version;
    private Date createDate;

    private String picPath;
    private String miniPicPath;
    private String mediumPicPath;

    private Double size;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getMiniPicPath() {
        return miniPicPath;
    }

    public void setMiniPicPath(String miniPicPath) {
        this.miniPicPath = miniPicPath;
    }

    public String getMediumPicPath() {
        return mediumPicPath;
    }

    public void setMediumPicPath(String mediumPicPath) {
        this.mediumPicPath = mediumPicPath;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
