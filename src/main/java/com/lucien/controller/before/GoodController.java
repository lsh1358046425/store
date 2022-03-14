package com.lucien.controller.before;

import com.github.pagehelper.PageInfo;
import com.lucien.model.entity.Category;
import com.lucien.model.entity.Good;
import com.lucien.service.CategoryService;
import com.lucien.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/18 14:47
 */

@Controller
public class GoodController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("details")
    public String details(@RequestParam int goodId, Map<String, Object> map){
        Good good = goodService.queryGoodByGoodId(goodId);
        map.put("good", good);
        return "before/details";
    }

    @RequestMapping("search")
    public String search(@RequestParam(required = false, defaultValue = "1") int page,
                         @RequestParam(required = false, defaultValue = "9") int limit,
                         @RequestParam(required = false) String keyword, Map<String, Object> map){
        PageInfo<Good> pageInfo = goodService.queryGoodByPage(page, limit, keyword);
        List<Good> goods = pageInfo.getList();
        List<Category> categories = categoryService.queryAllCategories();
        map.put("goods", pageInfo);
        map.put("keyword", keyword);
        map.put("categories", categories);
        return "before/search";
    }

    @RequestMapping("category")
    public String category(@RequestParam(required = false, defaultValue = "1") int page,
                         @RequestParam(required = false, defaultValue = "9") int limit,
                         @RequestParam(required = false) int categoryId, Map<String, Object> map){
        PageInfo<Good> pageInfo = goodService.queryGoodsByCategoryIdAndPage(page, limit, categoryId);
        List<Good> goods = pageInfo.getList();
        List<Category> categories = categoryService.queryAllCategories();
        map.put("goods", pageInfo);
        map.put("categoryId", categoryId);
        map.put("categories", categories);
        return "before/category";
    }
}
