package com.lucien.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/11 16:48
 */
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("admin") != null){
            return true;
        }
        response.sendRedirect("/store/admin/login");
        return false;
    }
}
