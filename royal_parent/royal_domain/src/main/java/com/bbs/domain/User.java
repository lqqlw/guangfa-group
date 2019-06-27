package com.bbs.domain;

import com.sun.corba.se.spi.ior.IORFactories;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private Integer userId;//用户ID
    private String userName;//用户名
    private String userPass;//密码
    private String email;//邮箱
    private String picUrl;//头像
    private Integer role;//1代表普通用户；2代表高级用户，3代表超级管理员
    private String roleStr;
    private Date lastLoginTime;//最后登录时间
    private Integer loginStatus;//登录状态，0代表未登录，1代表已登录
    private String loginStatusStr;
    private Integer talkStatus;//发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
    private String talkStatusStr;
    private Integer isupdating;//申请升级(0-未申请,1-已申请)
    private String isupdatingStr;
    private Integer updateStatus;//申请升级审核状态(0-未处理,1-已处理)
    private String updateStatusStr;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRoleStr() {
        //1代表普通用户；2代表高级用户，3代表超级管理员
        if (role != null) {
            if (role == 1) {
                roleStr = "普通用户";
            } else if (role == 2) {
                roleStr = "高级用户";
            } else if (role == 3) {
                roleStr = "超级管理员";
            }
        }
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginStatusStr() {
        //登录状态，0代表未登录，1代表已登录
        if (loginStatus != null) {
            if (loginStatus == 0) {
                loginStatusStr = "未登录";
            } else if (loginStatus == 1) {
                loginStatusStr = "已登录";
            }
        }
        return loginStatusStr;
    }

    public void setLoginStatusStr(String loginStatusStr) {
        this.loginStatusStr = loginStatusStr;
    }

    public Integer getTalkStatus() {
        return talkStatus;
    }

    public void setTalkStatus(Integer talkStatus) {
        this.talkStatus = talkStatus;
    }

    public String getTalkStatusStr() {
        //发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
        if (talkStatus != null) {
            if (talkStatus == 0) {
                talkStatusStr = "否";
            } else if (talkStatus == 1) {
                talkStatusStr = "是";
            }
        }
        return talkStatusStr;
    }

    public void setTalkStatusStr(String talkStatusStr) {
        this.talkStatusStr = talkStatusStr;
    }

    public Integer getIsupdating() {
        return isupdating;
    }

    public void setIsupdating(Integer isupdating) {
        this.isupdating = isupdating;
    }

    public String getIsupdatingStr() {
        //申请升级(0-未申请,1-已申请)
        if (isupdating != null) {
            if (isupdating == 0) {
                isupdatingStr = "未申请";
            } else if (isupdating == 1) {
                isupdatingStr = "已申请";
            }
        }
        return isupdatingStr;
    }

    public void setIsupdatingStr(String isupdatingStr) {
        this.isupdatingStr = isupdatingStr;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getUpdateStatusStr() {
        //申请升级审核状态(0-未处理,1-已处理)
        if (updateStatus != null) {
            if (updateStatus == 0) {
                updateStatusStr = "未处理";
            } else if (updateStatus == 1) {
                updateStatusStr = "已处理";
            }
        }
        return updateStatusStr;
    }

    public void setUpdateStatusStr(String updateStatusStr) {
        this.updateStatusStr = updateStatusStr;
    }
}
