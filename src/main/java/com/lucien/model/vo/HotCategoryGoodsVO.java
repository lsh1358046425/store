package com.lucien.model.vo;

import com.lucien.model.entity.Good;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/24 23:48
 */
public class HotCategoryGoodsVO {
    private List<Good> goods;

    private String categoryName;

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
