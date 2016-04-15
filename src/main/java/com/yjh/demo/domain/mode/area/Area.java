package com.yjh.demo.domain.mode.area;

import com.yjh.demo.core.enums.AreaLevel;
import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.id.ConcurrencySafeEntity;

import java.util.Date;

/**
 * Created by YJH on 2016/4/14.
 */
public class Area extends ConcurrencySafeEntity {

    private String name;            //地区名称
    private String shortName;       //简称
    private Double longitude;       //经度
    private Double latitude;        //维度
    private AreaLevel level;        //地区等级
    private Integer sort;           //排序
    private EnableStatus status;    //状态
    private Area parent;            //父级

    public void changeName(String name) {
        this.name = name;
    }

    public void changeShortName(String shortName) {
        this.shortName = shortName;
    }

    public void changeLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void changeLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void changeLevel(AreaLevel level) {
        this.level = level;
    }

    public void changeStatus(EnableStatus status) {
        this.status = status;
    }

    public void changeParent(Area parent) {
        this.parent = parent;
    }

    public void changeSort(Integer sort) {
        this.sort = sort;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setShortName(String shortName) {
        this.shortName = shortName;
    }

    private void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    private void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    private void setLevel(AreaLevel level) {
        this.level = level;
    }

    private void setStatus(EnableStatus status) {
        this.status = status;
    }

    private void setParent(Area parent) {
        this.parent = parent;
    }

    private void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public AreaLevel getLevel() {
        return level;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public Area getParent() {
        return parent;
    }

    public Integer getSort() {
        return sort;
    }

    public Area() {
        super();
    }

    public Area(String name, String shortName, Double longitude, Double latitude, AreaLevel level, EnableStatus status, Area parent, Integer sort) {
        this.name = name;
        this.shortName = shortName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.level = level;
        this.status = status;
        this.parent = parent;
        this.sort = sort;
        this.setCreateDate(new Date());
    }
}
