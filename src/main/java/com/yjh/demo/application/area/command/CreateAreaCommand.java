package com.yjh.demo.application.area.command;

import com.yjh.demo.core.enums.AreaLevel;
import com.yjh.demo.core.enums.EnableStatus;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by YJH on 2016/4/14.
 */
public class CreateAreaCommand {

    @NotBlank(message = "{area.name.NotBlank.message}")
    private String name;            //地区名称
    @NotBlank(message = "{area.shortName.NotBlank.messages}")
    private String shortName;       //简称
    @NotNull(message = "{area.longitude.NotNull.messages}")
    private Double longitude;       //经度
    @NotNull(message = "{area.latitude.NotNull.messages}")
    private Double latitude;        //维度
    @NotNull(message = "{area.level.NotNull.messages}")
    private AreaLevel level;        //地区等级
    @NotNull(message = "{area.status.NotNull.messages}")
    private EnableStatus status;    //状态
    @NotNull(message = "{area.sort.NotNull.messages}")
    private Integer sort;            //排序
    private String parent;            //父级

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
