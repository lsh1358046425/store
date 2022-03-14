package com.lucien.service;

import com.github.pagehelper.PageInfo;
import com.lucien.model.entity.Category;
import com.lucien.model.entity.Good;

import java.util.List;

public interface GoodService {
    PageInfo<Good> queryGoodByPage(int page, int limit, String keyword);

    int deleteGoodByGoodId(int goodId);

    int deleteGoodsByGoodIdList(List<Integer> goodIds);

    int addGood(Good good);

    int updateGoodByGoodId(Good good);

    Good queryGoodByGoodId(int goodId);

    List<Good> queryGoodsByCategoryHot(Category category);

    PageInfo<Good> queryGoodsByCategoryIdAndPage(int pageNum, int pageSize, int categoryId);

    List<Good> queryTodayGoods();
}
