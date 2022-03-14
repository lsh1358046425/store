package com.lucien.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucien.model.entity.JsonData;
import com.lucien.model.entity.LayUITableData;
import com.lucien.model.entity.User;
import com.lucien.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/25 22:53
 */

@Controller
@RequestMapping("admin")
public class AdminUserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userList")
    public String toUserList(){
        return "admin/user-list";
    }

    @ResponseBody
    @RequestMapping("getUserByPage")
    public LayUITableData getUserByPage(@RequestParam(required = false, defaultValue = "1") int page,
                                        @RequestParam(required = false, defaultValue = "10") int limit,
                                        @RequestParam(required = false) String keyword){

        LayUITableData layUIData = new LayUITableData();
        PageInfo<User> pageInfo = userService.queryUserByPage(page, limit, keyword);
        List<User> categories = pageInfo.getList();
        long count = pageInfo.getTotal();
        layUIData.setData(categories);
        layUIData.setCount(count);
        layUIData.setCode(0);
        return layUIData;
    }

    @ResponseBody
    @RequestMapping("userStatusUpdate")
    public JsonData userStatusUpdate(@RequestParam int userId, @RequestParam boolean userStatus){
        JsonData jsonData = new JsonData();
        int count = userService.updateUserStatusByUserId(userId,userStatus);
        jsonData.setMsg("状态更新成功");
        jsonData.setStatus(count);
        return jsonData;
    }
}
