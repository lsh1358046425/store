package com.lucien.controller.before;

import com.lucien.po.*;
import com.lucien.service.CartService;
import com.lucien.service.GoodService;
import com.lucien.service.OrdersService;
import com.lucien.util.TimeUtil;
import com.lucien.vo.OrderDetailVO;
import com.lucien.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/23 21:37
 */

@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodService goodService;

    @ResponseBody
    @RequestMapping("ordersSubmit")
    public JsonData ordersSubmit(@RequestParam String address, @RequestParam List<Integer> goodIds, HttpSession session){
        JsonData jsonData = new JsonData();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String orderId = userId + uuid;
        double amount = 0;
        for (int goodId : goodIds){
            Cart cart = cartService.queryCartByUserIdAndGoodId(userId, goodId);
            Good good = goodService.queryGoodByGoodId(goodId);
            amount += (cart.getCartNum() * good.getGoodPrice());
        }
        ordersService.addOrder(orderId, userId, address, amount);
        for (int goodId : goodIds){
            Cart cart = cartService.queryCartByUserIdAndGoodId(userId, goodId);
            ordersService.addOrderDetail(orderId, goodId, cart.getCartNum());
        }
        cartService.deleteCartByUserIdAndGoodIds(userId, goodIds);
        jsonData.setStatus(1);
        return jsonData;
    }

    @RequestMapping("orders")
    public String toOrders(Map<String, Object> map, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Orders> orders = ordersService.queryOrdersByUserId(user.getUserId());
        List<OrderVO> orderVOS = new ArrayList<>();
        for (Orders order : orders){
            OrderVO orderVO = new OrderVO();
            orderVO.setOrderAddress(order.getOrderAddress());
            orderVO.setOrderAmount(order.getOrderAmount());
            orderVO.setOrderDate(TimeUtil.getCurrentTimeByDate(order.getOrderDate()));
            orderVO.setOrderId(order.getOrderId());
            orderVO.setOrderStatus(order.getOrderStatus());
            orderVOS.add(orderVO);
        }
        map.put("orders", orderVOS);
        return "before/orders";
    }

    @RequestMapping("orderDetail")
    public String toOrderDetail(@RequestParam String orderId, Map<String, Object> map){
        List<Orderdetail> orderdetails = ordersService.queryOrderdetailByOrderId(orderId);
        List<OrderDetailVO> orderDetailVOS = new ArrayList<>();
        for (Orderdetail orderdetail : orderdetails){
            OrderDetailVO orderDetailVO = new OrderDetailVO();
            Good good = goodService.queryGoodByGoodId(orderdetail.getGoodId());
            orderDetailVO.setGoodName(good.getGoodName());
            orderDetailVO.setGoodPicture(good.getGoodPicture());
            orderDetailVO.setGoodPrice(good.getGoodPrice());
            orderDetailVO.setOrderDetailNum(orderdetail.getOrderdetailNum());
            orderDetailVOS.add(orderDetailVO);
        }
        map.put("orderDetails", orderDetailVOS);
        return "before/order-detail";
    }
}
