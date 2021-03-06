package com.yjh.demo.domain.mode.account;

import com.yjh.demo.core.enums.EnableStatus;
import com.yjh.demo.core.id.ConcurrencySafeEntity;
import com.yjh.demo.domain.mode.appkey.AppKey;
import com.yjh.demo.domain.mode.picture.Picture;
import com.yjh.demo.domain.mode.role.Role;

import java.util.Date;
import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public class Account extends ConcurrencySafeEntity {

    private String userName;        //用户名
    private String password;        //密码
    private String salt;            //密码加密盐
    private String lastLoginIP;     //最后登录ip
    private Date lastLoginDate;     //最后登录时间
    private String lastLoginPlatform;//最后登录平台
    private List<Role> roles;               //用户角色
    private AppKey appKey;          //应用标识
    private EnableStatus status;     //状态
    private Picture headPic;        //头像

    public void changeUserName(String userName) {
        this.userName = userName;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeSalt(String salt) {
        this.salt = salt;
    }

    public void changeLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public void changeLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void changeLastLoginPlatform(String lastLoginPlatform) {
        this.lastLoginPlatform = lastLoginPlatform;
    }

    public void changeRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void changeAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    public void changeStatus(EnableStatus status) {
        this.status = status;
    }

    public void changeHeadPic(Picture headPic) {
        this.headPic = headPic;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setSalt(String salt) {
        this.salt = salt;
    }

    private void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    private void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    private void setLastLoginPlatform(String lastLoginPlatform) {
        this.lastLoginPlatform = lastLoginPlatform;
    }

    private void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    private void setAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    private void setStatus(EnableStatus status) {
        this.status = status;
    }

    private void setHeadPic(Picture headPic) {
        this.headPic = headPic;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public String getLastLoginPlatform() {
        return lastLoginPlatform;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public AppKey getAppKey() {
        return appKey;
    }

    public EnableStatus getStatus() {
        return status;
    }

    public Picture getHeadPic() {
        return headPic;
    }

    public Account() {
        super();
    }

    public Account(String userName, String password, String salt, String lastLoginIP, Date lastLoginDate, String lastLoginPlatform, List<Role> roles, AppKey appKey, EnableStatus status) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.lastLoginIP = lastLoginIP;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginPlatform = lastLoginPlatform;
        this.roles = roles;
        this.appKey = appKey;
        this.status = status;
        this.setCreateDate(new Date());
    }
}
