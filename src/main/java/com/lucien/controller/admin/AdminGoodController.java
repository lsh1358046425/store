package com.lucien.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucien.model.entity.Category;
import com.lucien.model.entity.Good;
import com.lucien.model.entity.JsonData;
import com.lucien.model.entity.LayUITableData;
import com.lucien.service.CategoryService;
import com.lucien.service.GoodService;
import com.lucien.model.vo.ListGoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/3 20:18
 */

@Controller
@RequestMapping("admin")
public class AdminGoodController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("goodList")
    public String toGoodList() {
        return "admin/good-list";
    }

    @RequestMapping("toGoodAdd")
    public String toGoodAdd(Map<String, Object> map){
        List<Category> categories = categoryService.queryAllCategories();
        map.put("categories", categories);
        return "admin/good-add";
    }

    @RequestMapping("toGoodEdit")
    public String toGoodEdit(@RequestParam int goodId, Map<String, Object> map){
        Good good = goodService.queryGoodByGoodId(goodId);
        List<Category> categories = categoryService.queryAllCategories();
        map.put("good", good);
        map.put("categories", categories);
        return "admin/good-edit";
    }

    @ResponseBody
    @RequestMapping("goodEdit")
    public JsonData goodEdit(@RequestBody Good good){
        int count = goodService.updateGoodByGoodId(good);
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
    @RequestMapping("goodAdd")
    public JsonData goodAdd(@RequestParam String goodName, @RequestParam double goodPrice,
                            @RequestParam int categoryId, @RequestParam String goodPicture){
        Good good = new Good();
        good.setGoodName(goodName);
        good.setGoodPrice(goodPrice);
        good.setCategoryId(categoryId);
        good.setGoodPicture(goodPicture);
        int count = goodService.addGood(good);
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
    @RequestMapping("getGoodByPage")
    public LayUITableData getCategoryByPage(@RequestParam(required = false, defaultValue = "1") int page,
                                            @RequestParam(required = false, defaultValue = "10") int limit,
                                            @RequestParam(required = false) String keyword) {
        LayUITableData layUIData = new LayUITableData();
        PageInfo<Good> pageInfo = goodService.queryGoodByPage(page, limit, keyword);
        List<Good> goods = pageInfo.getList();  //获得商品列表
        List<ListGoodVO> listGoodVOS = new ArrayList<>();   //存放商品VO
        //循环把每个PO转化成VO
        for (Good good : goods) {
            ListGoodVO listGoodVO = new ListGoodVO();
            listGoodVO.setGoodId(good.getGoodId());
            listGoodVO.setGoodName(good.getGoodName());
            listGoodVO.setGoodPicture(good.getGoodPicture());
            listGoodVO.setGoodPrice(good.getGoodPrice());
            listGoodVO.setCategoryName(categoryService.queryCategoryNameByCategoryId(good.getCategoryId()).getCategoryName());  //查询分类并获取分类名存入商品VO
            listGoodVOS.add(listGoodVO);    //把商品VO加入商品VO列表
        }
        long count = pageInfo.getTotal();
        layUIData.setData(listGoodVOS);
        layUIData.setCount(count);
        layUIData.setCode(0);
        return layUIData;
    }

    @ResponseBody
    @RequestMapping("deleteGood")
    public JsonData deleteGood(@RequestParam int goodId) {
        int count = goodService.deleteGoodByGoodId(goodId);
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
    @RequestMapping("deleteGoods")
    public JsonData deleteGoods(@RequestBody List<Integer> goodIds) {
        int count = goodService.deleteGoodsByGoodIdList(goodIds);
        JsonData jsonData = new JsonData();
        if (count == goodIds.size()) {
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
    @RequestMapping("uploadPicture")
    public JsonData uploadPicture(@RequestParam("file") MultipartFile file, HttpSession session) {
        JsonData jsonData = new JsonData();
        String realPath = session.getServletContext().getRealPath(File.separator);
        String savePath = "/images/";
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String path = realPath + savePath + uuid + ".png";
        try {
            File newFile=new File(path);
            file.transferTo(newFile);
        } catch (IOException e) {
            jsonData.setStatus(0);
            jsonData.setMsg("上传失败");
            return jsonData;
        }
        jsonData.setStatus(1);
        jsonData.setData(uuid + ".png");
        jsonData.setMsg("上传成功");
        return jsonData;
    }
}
