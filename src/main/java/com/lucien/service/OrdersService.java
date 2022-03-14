package com.lucien.service;

import com.github.pagehelper.PageInfo;
import com.lucien.model.entity.Orderdetail;
import com.lucien.model.entity.Orders;

import java.util.Date;
import java.util.List;

public interface OrdersService {
    int addOrder(String orderId, int userId, String orderAddress, double orderAmount);

    int addOrderDetail(String orderId, int goodId, int orderDetailNum);

    List<Orders> queryOrdersByUserId(int userId);

    List<Orderdetail> queryOrderdetailByOrderId(String orderId);

    PageInfo<Orders> queryOrdersByPage(int pageNum, int pageSize, String keyword, Date start, Date end);
}
