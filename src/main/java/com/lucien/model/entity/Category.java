package com.lucien.model.entity;

public class Category {
    private Integer categoryId;

    private String categoryName;

    private Boolean categoryHot;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Boolean getCategoryHot() {
        return categoryHot;
    }

    public void setCategoryHot(Boolean categoryHot) {
        this.categoryHot = categoryHot;
    }
}