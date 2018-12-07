package com.managementSystem.pojo;

import java.util.Date;

public class Shop_Credit {
    private String shopId;

    private Date latestUpdateTime;

    private Integer credit;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public Date getLatestUpdateTime() {
        return latestUpdateTime;
    }

    public void setLatestUpdateTime(Date latestUpdateTime) {
        this.latestUpdateTime = latestUpdateTime;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}