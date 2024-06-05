package com.sd.service;

import com.sd.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sd.entity.OrderQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【order】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface OrderService extends IService<Order> {
    List<Order> getAllOrder();
    List<Order> getOrdersById(int uid);
    int createOrder(Order order);
    int deleteOrder(int id);
    int updateOrder(Order order);
    void deleteOrders(List<Integer> ids);
    List<Order> queryOrder(OrderQuery orderQuery);
}
