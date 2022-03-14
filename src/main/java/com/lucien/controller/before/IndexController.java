package com.lucien.controller.before;

import com.lucien.model.entity.Category;
import com.lucien.model.entity.Good;
import com.lucien.model.entity.Notice;
import com.lucien.service.CategoryService;
import com.lucien.service.GoodService;
import com.lucien.service.NoticeService;
import com.lucien.model.vo.HotCategoryGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/8 20:49
 */

@Controller
public class IndexController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private NoticeService noticeService;

    @RequestMapping({"/", "/index"})
    public String index(Map<String, Object> map){
        List<Category> categories = categoryService.queryAllCategories();
        List<Category> hotCategories = categoryService.queryHotCategories();
        List<Good> todayGoods = goodService.queryTodayGoods();
        Notice notice = noticeService.queryNoticeByNoticeStatus();
        List<HotCategoryGoodsVO> hotCategoriesGoods = new ArrayList<>();
        for (Category category : hotCategories){
            HotCategoryGoodsVO hotCategoryGoodsVO = new HotCategoryGoodsVO();
            List<Good> goods = goodService.queryGoodsByCategoryHot(category);
            hotCategoryGoodsVO.setGoods(goods);
            hotCategoryGoodsVO.setCategoryName(category.getCategoryName());
            hotCategoriesGoods.add(hotCategoryGoodsVO);
        }
        map.put("hotCategoriesGoods", hotCategoriesGoods);
        map.put("categories", categories);
        map.put("todayGoods", todayGoods);
        map.put("notice", notice);
        return "before/index";
    }
}
