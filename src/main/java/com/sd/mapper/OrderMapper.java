package com.sd.mapper;

import com.sd.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sd.entity.OrderQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> findAllOrder();
    int createOrder(Order order);
    int deleteOrder(int id);
    int updateOrder(Order order);
    void deleteOrders(List<Integer> ids);
    List<Order> findOrdersById(int uid);
    List<Order> queryOrder(OrderQuery orderQuery);
}