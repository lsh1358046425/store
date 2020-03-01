package com.lucien.po;

public class Good {
    private Integer goodId;

    private String goodName;

    private Double goodPrice;

    private String goodPicture;

    private Integer categoryId;

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
        this.goodName = goodName == null ? null : goodName.trim();
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
        this.goodPicture = goodPicture == null ? null : goodPicture.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}