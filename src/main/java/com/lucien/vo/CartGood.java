package com.lucien.vo;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/22 21:09
 */
public class CartGood {
    private Integer goodId;

    private String goodName;

    private Double goodPrice;

    private String goodPicture;

    private Integer CartNum;

    private Double CartAmount;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

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

    public Integer getCartNum() {
        return CartNum;
    }

    public void setCartNum(Integer cartNum) {
        CartNum = cartNum;
    }

    public Double getCartAmount() {
        return CartAmount;
    }

    public void setCartAmount(Double cartAmount) {
        CartAmount = cartAmount;
    }
}
