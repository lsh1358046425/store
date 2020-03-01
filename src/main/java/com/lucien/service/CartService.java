package com.lucien.service;

import com.lucien.po.Cart;

import java.util.List;

public interface CartService {
    int addCart(int userId, int goodId, int cartNum);

    int deleteCartByUserIdAndGoodId(int userId, int goodId);

    int deleteCartByUserIdAndGoodIds(int userId, List<Integer> goodIds);

    List<Cart> queryCartsByUserId(int userId);

    Cart queryCartByUserIdAndGoodId(int userId, int goodId);

    int updateCartByUserIdAndGoodId(int userId, int goodId, int cartNum);
}
