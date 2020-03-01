package com.lucien.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucien.po.*;
import com.lucien.service.GoodService;
import com.lucien.service.OrdersService;
import com.lucien.service.UserService;
import com.lucien.util.TimeUtil;
import com.lucien.vo.OrderDetailVO;
import com.lucien.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/8 21:05
 */

@Controller
@RequestMapping("admin")
public class AdminOrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodService goodService;

    @RequestMapping("orderList")
    public String orderList() {
        return "admin/order-list";
    }

    @ResponseBody
    @RequestMapping("getOrderByPage")
    public LayUITableData getOrderByPage(@RequestParam(required = false, defaultValue = "1") int page,
                                         @RequestParam(required = false, defaultValue = "10") int limit,
                                         @RequestParam(required = false) String keyword,
                                         @RequestParam(required = false) Date start,
                                         @RequestParam(required = false) Date end) {
        LayUITableData layUIData = new LayUITableData();
        PageInfo<Orders> pageInfo = ordersService.queryOrdersByPage(page, limit, keyword, start, end);
        List<Orders> orders = pageInfo.getList();
        List<OrderVO> orderVOS = new ArrayList<>();
        for (Orders order : orders){
            OrderVO orderVO = new OrderVO();
            User user = userService.queryUserByUserId(order.getUserId());
            orderVO.setUserName(user.getUserName());
            orderVO.setOrderStatus(order.getOrderStatus());
            orderVO.setOrderId(order.getOrderId());
            orderVO.setOrderDate(TimeUtil.getCurrentTimeByDate(order.getOrderDate()));
            orderVO.setOrderAmount(order.getOrderAmount());
            orderVO.setOrderAddress(order.getOrderAddress());
            orderVOS.add(orderVO);
        }
        long count = pageInfo.getTotal();
        layUIData.setData(orderVOS);
        layUIData.setCount(count);
        layUIData.setCode(0);
        return layUIData;
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
        return "admin/order-detail";
    }
}
