package com.lucien.controller.before;

import com.lucien.model.entity.JsonData;
import com.lucien.model.entity.User;
import com.lucien.service.UserService;
import com.lucien.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/19 19:37
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(HttpSession session){
        if (session.getAttribute("user") != null) {
            return "before/index";
        }
        return "before/login";
    }

    @ResponseBody
    @RequestMapping("register")
    public JsonData register(@RequestParam String userName, @RequestParam String userPassword){
        JsonData jsonData = new JsonData();
        List<User> user = userService.queryUserByUserName(userName);
        if (!user.isEmpty()){
            jsonData.setStatus(0);
            jsonData.setMsg("用户名已存在");
            return jsonData;
        }
        int count = userService.addUser(userName, userPassword);
        if (count == 1){
            jsonData.setStatus(1);
            jsonData.setMsg("注册成功");
            return jsonData;
        }else {
            jsonData.setStatus(0);
            jsonData.setMsg("注册失败");
            return jsonData;
        }
    }

    @ResponseBody
    @RequestMapping("checkLogin")
    public JsonData checkLogin(@RequestParam String userName, @RequestParam String userPassword, HttpSession session){
        List<User> user = userService.queryUserByUserName(userName);
        JsonData jsonData = new JsonData();
        if (user.size() < 1) {
            jsonData.setStatus(0);
            jsonData.setMsg("用户名不存在");
            return jsonData;
        } else {
            if (user.get(0).getUserStatus()) {
                String md5 = MD5Util.getMD5(userPassword);
                String password = user.get(0).getUserPassword();
                if (md5.equals(password)) {
                    session.setMaxInactiveInterval(60 * 60 * 24);
                    session.setAttribute("user", user.get(0));
                    jsonData.setStatus(1);
                    jsonData.setMsg("登录成功");
                    return jsonData;
                } else {
                    jsonData.setStatus(0);
                    jsonData.setMsg("密码错误");
                    return jsonData;
                }
            }else {
                jsonData.setStatus(0);
                jsonData.setMsg("您的帐户已被禁用，请联系管理员");
                return jsonData;
            }
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
