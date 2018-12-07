package com.managementSystem.pojo;

import java.util.Date;

public class Consumer_Credit {
    private String consumerId;

    private Date latestUpdateTime;

    private Integer credit;

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId == null ? null : consumerId.trim();
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