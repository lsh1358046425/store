package com.lucien.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucien.model.entity.Category;
import com.lucien.model.entity.JsonData;
import com.lucien.model.entity.LayUITableData;
import com.lucien.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/3 20:44
 */

@Controller
@RequestMapping("admin")
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("categoryList")
    public String toCategoryList() {
        return "admin/category-list";
    }

    @ResponseBody
    @RequestMapping("getCategoryByPage")
    public LayUITableData getCategoryByPage(@RequestParam(required = false, defaultValue = "1") int page,
                                            @RequestParam(required = false, defaultValue = "10") int limit) {
        LayUITableData layUIData = new LayUITableData();
        PageInfo<Category> pageInfo = categoryService.queryCategoryByPage(page, limit);
        List<Category> categories = pageInfo.getList();
        long count = pageInfo.getTotal();
        layUIData.setData(categories);
        layUIData.setCount(count);
        layUIData.setCode(0);
        return layUIData;
    }

    @ResponseBody
    @RequestMapping("deleteCategory")
    public JsonData deleteCategory(@RequestParam int categoryId) {
        int count = categoryService.deleteCategoryByCategoryId(categoryId);
        JsonData jsonData = new JsonData();
        if (count == 1) {
            jsonData.setMsg("删除成功");
            jsonData.setStatus(1);
            return jsonData;
        }else {
            jsonData.setMsg("删除失败");
            jsonData.setStatus(0);
            return jsonData;
        }
    }

    @ResponseBody
    @RequestMapping("addCategory")
    public JsonData addCategory(@RequestParam String categoryName){
        int count = categoryService.addCategory(categoryName);
        JsonData jsonData = new JsonData();
        if (count == 1) {
            jsonData.setMsg("添加成功");
            jsonData.setStatus(1);
            return jsonData;
        }else {
            jsonData.setMsg("添加失败");
            jsonData.setStatus(0);
            return jsonData;
        }
    }

    @ResponseBody
    @RequestMapping("updateCategoryHot")
    public JsonData updateCategoryHot(@RequestParam int categoryId, @RequestParam boolean categoryHot){
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryHot(categoryHot);
        int count = categoryService.updateCategoryByCategoryId(category);
        JsonData jsonData = new JsonData();
        if (count == 1) {
            jsonData.setMsg("更新成功");
            jsonData.setStatus(1);
            return jsonData;
        }else {
            jsonData.setMsg("更新失败");
            jsonData.setStatus(0);
            return jsonData;
        }
    }


    @ResponseBody
    @RequestMapping("updateCategory")
    public JsonData updateCategory(@RequestBody Category category){
        int count = categoryService.updateCategoryByCategoryId(category);
        JsonData jsonData = new JsonData();
        if (count == 1) {
            jsonData.setMsg("更新成功");
            jsonData.setStatus(1);
            return jsonData;
        }else {
            jsonData.setMsg("更新失败");
            jsonData.setStatus(0);
            return jsonData;
        }
    }
}
