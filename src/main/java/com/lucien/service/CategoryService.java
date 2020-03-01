package com.lucien.service;

import com.github.pagehelper.PageInfo;
import com.lucien.po.Category;

import java.util.List;


public interface CategoryService {
    PageInfo<Category> queryCategoryByPage(int pageNum, int pageSize);

    int deleteCategoryByCategoryId(int categoryId);

    int addCategory(String categoryName);

    int updateCategoryByCategoryId(Category category);

    Category queryCategoryNameByCategoryId(int categoryId);

    List<Category> queryAllCategories();

    List<Category> queryHotCategories();
}
