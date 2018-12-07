package com.managementSystem.pojo;

import java.util.Date;

public class Shop {
    private String shopId;

    private String userName;

    private String password;

    private String phone;

    private Date businessStartTime;

    private Date businessEndTime;

    private Date signupTime;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(Date businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public Date getBusinessEndTime() {
        return businessEndTime;
    }

    public void setBusinessEndTime(Date businessEndTime) {
        this.businessEndTime = businessEndTime;
    }

    public Date getSignupTime() {
        return signupTime;
    }

    public void setSignupTime(Date signupTime) {
        this.signupTime = signupTime;
    }
}