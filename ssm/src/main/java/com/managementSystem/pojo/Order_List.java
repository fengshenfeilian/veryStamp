package com.managementSystem.pojo;

import java.util.Date;

public class Order_List {
    private String orderId;

    private String userId;

    private String shopId;

    private String resId;

    private String printFormat;

    private Integer printCount;

    private Date orderTime;

    private Date readyTime;

    private Date finishTime;

    private Date targetTakeTime;

    private String state;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getPrintFormat() {
        return printFormat;
    }

    public void setPrintFormat(String printFormat) {
        this.printFormat = printFormat == null ? null : printFormat.trim();
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(Date readyTime) {
        this.readyTime = readyTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getTargetTakeTime() {
        return targetTakeTime;
    }

    public void setTargetTakeTime(Date targetTakeTime) {
        this.targetTakeTime = targetTakeTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}