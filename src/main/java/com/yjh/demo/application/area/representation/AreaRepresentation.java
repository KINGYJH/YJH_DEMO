package com.yjh.demo.application.area.representation;

import com.yjh.demo.core.enums.AreaLevel;
import com.yjh.demo.core.enums.EnableStatus;

import java.util.Date;

/**
 * Created by YJH on 2016/4/14.
 */
public class AreaRepresentation {

    private String id;
    private Integer version;
    private Date createDate;

    private String name;            //地区名称
    private String shortName;       //简称
    private Double longitude;       //经度
    private Double latitude;        //维度
    private AreaLevel level;        //地区等级
    private EnableStatus status;    //状态
    private Integer sort;           //排序
    private AreaRepresentation parent;            //父级

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public AreaLevel getLevel() {
        return level;
    }

    public void setLevel(AreaLevel level) {
        this.level = level;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public void setStatus(EnableStatus status) {
        this.status = status;
    }

    public AreaRepresentation getParent() {
        return parent;
    }

    public void setParent(AreaRepresentation parent) {
        this.parent = parent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
