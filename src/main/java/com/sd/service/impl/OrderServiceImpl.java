package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Order;
import com.sd.entity.OrderQuery;
import com.sd.service.OrderService;
import com.sd.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【order】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.findAllOrder();
    }
    @Override
    public void deleteOrders(List<Integer> ids){
        orderMapper.deleteOrders(ids);
    }

    @Override
    public List<Order> queryOrder(OrderQuery orderQuery) {
        return orderMapper.queryOrder(orderQuery);
    }

    @Override
    public List<Order> getOrdersById(int uid) {
        return orderMapper.findOrdersById(uid);
    }

    @Override
    public int createOrder(Order order) {
        return orderMapper.createOrder(order);
    }

    @Override
    public int deleteOrder(int id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

}