package com.lucien.service.impl;

import com.lucien.dao.CartMapper;
import com.lucien.model.entity.Cart;
import com.lucien.model.entity.CartExample;
import com.lucien.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/19 18:18
 */

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public int addCart(int userId, int goodId, int cartNum) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setGoodId(goodId);
        cart.setCartNum(cartNum);
        return cartMapper.insertSelective(cart);
    }

    @Override
    public int deleteCartByUserIdAndGoodId(int userId, int goodId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andGoodIdEqualTo(goodId);
        return cartMapper.deleteByExample(example);
    }

    @Override
    public int deleteCartByUserIdAndGoodIds(int userId, List<Integer> goodIds) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andGoodIdIn(goodIds);
        return cartMapper.deleteByExample(example);
    }

    @Override
    public List<Cart> queryCartsByUserId(int userId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return cartMapper.selectByExample(example);
    }

    @Override
    public Cart queryCartByUserIdAndGoodId(int userId, int goodId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andGoodIdEqualTo(goodId);
        List<Cart> carts = cartMapper.selectByExample(example);
        if (carts.isEmpty()){
            return null;
        }
        return carts.get(0);
    }

    @Override
    public int updateCartByUserIdAndGoodId(int userId, int goodId, int cartNum) {
        Cart cart = new Cart();
        cart.setCartNum(cartNum);
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andGoodIdEqualTo(goodId);
        return cartMapper.updateByExampleSelective(cart, example);
    }
}
