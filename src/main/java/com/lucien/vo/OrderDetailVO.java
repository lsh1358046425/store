package com.lucien.vo;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/26 16:51
 */
public class OrderDetailVO {
    private String goodName;

    private Double goodPrice;

    private String goodPicture;

    private Integer orderDetailNum;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodPicture() {
        return goodPicture;
    }

    public void setGoodPicture(String goodPicture) {
        this.goodPicture = goodPicture;
    }

    public Integer getOrderDetailNum() {
        return orderDetailNum;
    }

    public void setOrderDetailNum(Integer orderDetailNum) {
        this.orderDetailNum = orderDetailNum;
    }
}
