package com.lucien.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucien.dao.CategoryMapper;
import com.lucien.po.Category;
import com.lucien.po.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/8 17:34
 */

@Service("categoryService")
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<Category> queryCategoryByPage(int pageNum, int pageSize) {
        CategoryExample example = new CategoryExample();
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categories = categoryMapper.selectByExample(example);
        return new PageInfo<>(categories);
    }

    @Override
    public int deleteCategoryByCategoryId(int categoryId) {
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public int addCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return categoryMapper.insertSelective(category);
    }

    @Override
    public int updateCategoryByCategoryId(Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public Category queryCategoryNameByCategoryId(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public List<Category> queryAllCategories() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> queryHotCategories() {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryHotEqualTo(true);
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }
}
