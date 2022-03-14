package com.lucien.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucien.dao.OrderdetailMapper;
import com.lucien.dao.OrdersMapper;
import com.lucien.model.entity.Orderdetail;
import com.lucien.model.entity.OrderdetailExample;
import com.lucien.model.entity.Orders;
import com.lucien.model.entity.OrdersExample;
import com.lucien.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/25 20:56
 */

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public int addOrder(String orderId, int userId, String orderAddress, double orderAmount) {
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setOrderDate(new Date());
        order.setOrderAddress(orderAddress);
        order.setOrderAmount(orderAmount);
        return ordersMapper.insertSelective(order);
    }

    @Override
    public int addOrderDetail(String orderId, int goodId, int orderDetailNum) {
        Orderdetail orderdetail = new Orderdetail();
        orderdetail.setGoodId(goodId);
        orderdetail.setOrderId(orderId);
        orderdetail.setOrderdetailNum(orderDetailNum);
        return orderdetailMapper.insertSelective(orderdetail);
    }

    @Override
    public List<Orders> queryOrdersByUserId(int userId) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return ordersMapper.selectByExample(example);
    }

    @Override
    public List<Orderdetail> queryOrderdetailByOrderId(String orderId) {
        OrderdetailExample example = new OrderdetailExample();
        OrderdetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderdetailMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Orders> queryOrdersByPage(int pageNum, int pageSize, String keyword, Date start, Date end) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        if (start != null && end != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(end);//设置起时间
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            end = calendar.getTime();
            criteria.andOrderDateBetween(start, end);
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andOrderIdLike('%' + keyword + '%');
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> orders = ordersMapper.selectByExample(example);
        return new PageInfo<>(orders);
    }
}
