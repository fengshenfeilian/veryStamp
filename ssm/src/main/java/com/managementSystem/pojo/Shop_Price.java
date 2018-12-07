package com.managementSystem.pojo;

import java.math.BigDecimal;

public class Shop_Price {
    private String shopId;

    private BigDecimal singlePagePrice;

    private BigDecimal doublePagePrice;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public BigDecimal getSinglePagePrice() {
        return singlePagePrice;
    }

    public void setSinglePagePrice(BigDecimal singlePagePrice) {
        this.singlePagePrice = singlePagePrice;
    }

    public BigDecimal getDoublePagePrice() {
        return doublePagePrice;
    }

    public void setDoublePagePrice(BigDecimal doublePagePrice) {
        this.doublePagePrice = doublePagePrice;
    }
}