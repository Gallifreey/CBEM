package com.sd.mapper;

import com.sd.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> findAllOrder();
    int createOrder(Order order);
    int deleteOrder(int id);
    int updateOrder(Order order);

    List<Order> findOrdersById(int uid);
}