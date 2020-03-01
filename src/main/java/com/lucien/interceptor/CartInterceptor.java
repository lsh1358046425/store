package com.lucien.interceptor;

import com.lucien.po.Cart;
import com.lucien.po.User;
import com.lucien.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/20 23:05
 */
public class CartInterceptor implements HandlerInterceptor {
    @Autowired
    private CartService cartService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            List<Cart> carts = cartService.queryCartsByUserId(user.getUserId());
            int cartNum = 0;
            for (Cart cart : carts){
                cartNum += cart.getCartNum();
            }
            request.getSession().setAttribute("cartNum", cartNum);
        }
        return true;
    }
}
