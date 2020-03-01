package com.lucien.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucien.dao.GoodMapper;
import com.lucien.po.Category;
import com.lucien.po.Good;
import com.lucien.po.GoodExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/8 17:36
 */

@Service("goodService")
@Transactional
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;

    @Override
    public PageInfo<Good> queryGoodByPage(int pageNum, int pageSize, String keyword) {
        GoodExample example = new GoodExample();
        if (!StringUtils.isEmpty(keyword)) {
            GoodExample.Criteria criteria = example.createCriteria();
            criteria.andGoodNameLike('%' + keyword + '%');
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Good> goods = goodMapper.selectByExample(example);
        return new PageInfo<>(goods);
    }

    @Override
    public int deleteGoodByGoodId(int goodId) {
        return goodMapper.deleteByPrimaryKey(goodId);
    }

    @Override
    public int deleteGoodsByGoodIdList(List<Integer> goodIds) {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        criteria.andGoodIdIn(goodIds);
        return goodMapper.deleteByExample(example);
    }

    @Override
    public int addGood(Good good) {
        return goodMapper.insertSelective(good);
    }

    @Override
    public int updateGoodByGoodId(Good good) {
        return goodMapper.updateByPrimaryKeySelective(good);
    }

    @Override
    public Good queryGoodByGoodId(int goodId) {
        return goodMapper.selectByPrimaryKey(goodId);
    }

    @Override
    public List<Good> queryGoodsByCategoryHot(Category category) {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(category.getCategoryId());
        //这里我只是拿PageHelper当limit用哈哈
        PageHelper.startPage(1, 5);
        return goodMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Good> queryGoodsByCategoryIdAndPage(int pageNum, int pageSize, int categoryId) {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(pageNum, pageSize);
        List<Good> goods = goodMapper.selectByExample(example);
        return new PageInfo<>(goods);
    }

    @Override
    public List<Good> queryTodayGoods() {
        GoodExample example = new GoodExample();
        example.setLimit(8);
        return goodMapper.selectByExample(example);
    }
}
