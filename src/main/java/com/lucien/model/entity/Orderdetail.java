package com.lucien.model.entity;

public class Orderdetail {
    private Integer orderdetailId;

    private String orderId;

    private Integer goodId;

    private Integer orderdetailNum;

    public Integer getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(Integer orderdetailId) {
        this.orderdetailId = orderdetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getOrderdetailNum() {
        return orderdetailNum;
    }

    public void setOrderdetailNum(Integer orderdetailNum) {
        this.orderdetailNum = orderdetailNum;
    }
}