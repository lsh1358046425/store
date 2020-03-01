package com.lucien.interceptor;

import com.lucien.po.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/19 20:58
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            return true;
        }
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }
}