package com.lucien.controller.admin;

import com.lucien.model.entity.Admin;
import com.lucien.model.entity.JsonData;
import com.lucien.service.AdminService;
import com.lucien.util.MD5Util;
import com.lucien.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/11 12:02
 */

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping({"/", "/index"})
    public String index(){
        return "admin/index";
    }

    @RequestMapping("login")
    public String toLogin(HttpSession session){
        if (session.getAttribute("admin") != null) {
            return "admin/index";
        }
        return "admin/login";
    }

    @ResponseBody
    @RequestMapping("checkLogin")
    public JsonData checkLogin(@RequestBody Admin checkAdmin, HttpSession session){
        Admin admin = adminService.queryAdminByAdminName(checkAdmin.getAdminName());
        JsonData jsonData = new JsonData();
        if (admin == null) {
            jsonData.setStatus(0);
            jsonData.setMsg("用户名不存在");
            return jsonData;
        } else {
            String md5 = MD5Util.getMD5(checkAdmin.getAdminPassword());
            String password = admin.getAdminPassword();
            if (md5.equals(password)){
                session.setMaxInactiveInterval(60 * 60 * 24);
                session.setAttribute("admin", admin);
                jsonData.setStatus(1);
                jsonData.setMsg("登录成功");
                return jsonData;
            }else {
                jsonData.setStatus(0);
                jsonData.setMsg("密码错误");
                return jsonData;
            }
        }
    }

    @RequestMapping("welcome")
    public String welcome(Map<String, Object> map) {
        map.put("date", TimeUtil.getCurrentTime());
        return "admin/welcome";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/login";
    }

}
