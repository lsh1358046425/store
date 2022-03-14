package com.lucien.controller.before;

import com.lucien.model.entity.Cart;
import com.lucien.model.entity.Good;
import com.lucien.model.entity.JsonData;
import com.lucien.model.entity.User;
import com.lucien.service.CartService;
import com.lucien.service.GoodService;
import com.lucien.model.vo.CartGoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/19 18:01
 */

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodService goodService;

    @RequestMapping("checkout")
    public String checkout(@RequestParam List<Integer> goodIds, HttpSession session, Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        List<CartGoodVO> goods = new ArrayList<>();
        for(int goodId : goodIds){
            CartGoodVO cartGoodVO = new CartGoodVO();
            Cart cart = cartService.queryCartByUserIdAndGoodId(userId, goodId);
            Good good = goodService.queryGoodByGoodId(cart.getGoodId());
            cartGoodVO.setGoodId(good.getGoodId());
            cartGoodVO.setGoodName(good.getGoodName());
            cartGoodVO.setGoodPrice(good.getGoodPrice());
            cartGoodVO.setGoodPicture(good.getGoodPicture());
            cartGoodVO.setCartNum(cart.getCartNum());
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            double amount = Double.parseDouble(decimalFormat.format(good.getGoodPrice() * cart.getCartNum()));
            cartGoodVO.setCartAmount(amount);
            goods.add(cartGoodVO);
        }
        map.put("goods", goods);
        return "before/checkout";
    }

    @RequestMapping("cart")
    public String cart(Map<String, Object> map, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Cart> carts = cartService.queryCartsByUserId(user.getUserId());
        List<CartGoodVO> goods = new ArrayList<>();
        for(Cart cart : carts){
            CartGoodVO cartGoodVO = new CartGoodVO();
            Good good = goodService.queryGoodByGoodId(cart.getGoodId());
            cartGoodVO.setGoodId(good.getGoodId());
            cartGoodVO.setGoodName(good.getGoodName());
            cartGoodVO.setGoodPrice(good.getGoodPrice());
            cartGoodVO.setGoodPicture(good.getGoodPicture());
            cartGoodVO.setCartNum(cart.getCartNum());
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            double amount = Double.parseDouble(decimalFormat.format(good.getGoodPrice() * cart.getCartNum()));
            cartGoodVO.setCartAmount(amount);
            goods.add(cartGoodVO);
        }
        map.put("goods", goods);
        return "before/cart";
    }

    @ResponseBody
    @RequestMapping("cartAdd")
    public JsonData cartAdd(@RequestParam int goodId, @RequestParam(required = false, defaultValue = "1") int cartNum,
                            HttpSession session){
        JsonData jsonData = new JsonData();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        int count;

        Cart cart = cartService.queryCartByUserIdAndGoodId(userId, goodId);
        if (cart != null){
            count = cartService.updateCartByUserIdAndGoodId(userId, goodId, cart.getCartNum() + cartNum);
            if (count == 1) {
                jsonData.setMsg("添加成功");
                jsonData.setStatus(1);
                return jsonData;
            } else {
                jsonData.setMsg("添加失败");
                jsonData.setStatus(0);
                return jsonData;
            }
        }

        count = cartService.addCart(userId, goodId, cartNum);
        if (count == 1) {
            jsonData.setMsg("添加成功");
            jsonData.setStatus(1);
            return jsonData;
        } else {
            jsonData.setMsg("添加失败");
            jsonData.setStatus(0);
            return jsonData;
        }

    }

    @ResponseBody
    @RequestMapping("cartDelete")
    public JsonData cartDelete(@RequestParam int goodId, HttpSession session){
        JsonData jsonData = new JsonData();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        int count = cartService.deleteCartByUserIdAndGoodId(userId, goodId);
        jsonData.setStatus(count);
        return jsonData;
    }

    @ResponseBody
    @RequestMapping("cartsDelete")
    public JsonData cartsDelete(@RequestBody List<Integer> goodIds, HttpSession session) {
        JsonData jsonData = new JsonData();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        int count = cartService.deleteCartByUserIdAndGoodIds(userId, goodIds);
        jsonData.setStatus(count);
        return jsonData;
    }

    @ResponseBody
    @RequestMapping("cartNumAdd")
    public JsonData cartNumAdd(@RequestParam int goodId, HttpSession session){
        JsonData jsonData = new JsonData();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Cart cart = cartService.queryCartByUserIdAndGoodId(userId, goodId);
        int count = cartService.updateCartByUserIdAndGoodId(userId, goodId, cart.getCartNum() + 1);
        jsonData.setStatus(count);
        return jsonData;
    }

    @ResponseBody
    @RequestMapping("cartNumSub")
    public JsonData cartNumSub(@RequestParam int goodId, HttpSession session){
        JsonData jsonData = new JsonData();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Cart cart = cartService.queryCartByUserIdAndGoodId(userId, goodId);
        int count = cartService.updateCartByUserIdAndGoodId(userId, goodId, cart.getCartNum() - 1);
        jsonData.setStatus(count);
        return jsonData;
    }
}
