package com.sd.controller;

import com.alibaba.fastjson.JSON;
import com.sd.entity.Order;
import com.sd.entity.OrderQuery;
import com.sd.entity.PriceMeta;
import com.sd.entity.Result;
import com.sd.service.impl.OrderServiceImpl;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public Result getAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        // 将每个订单的pricemeta字符串转换为JSON对象
        orders.forEach(order -> {
            String pricemeta = order.getPricemeta();
            order.setKey(order.getId());
            if (pricemeta != null && !pricemeta.isEmpty()) {
                PriceMeta meta = JSON.parseObject(pricemeta).toJavaObject(PriceMeta.class);
                order.setMeta(meta); // 假设Order类有这样一个字段
            }
        });
        return Result.success(orders);
    }
    @GetMapping("/list")
    public Result getOrdersById(@RequestParam int uid){
        List<Order> orders = orderService.getOrdersById(uid);
        // 将每个订单的pricemeta字符串转换为JSON对象
        orders.forEach(order -> {
            String pricemeta = order.getPricemeta();
            order.setKey(order.getId());
            if (pricemeta != null && !pricemeta.isEmpty()) {
                PriceMeta meta = JSON.parseObject(pricemeta).toJavaObject(PriceMeta.class);
                order.setMeta(meta); // 假设Order类有这样一个字段
            }
        });
        return Result.success(orders);
    }
    @PostMapping("/query")
    public Result queryOrders(@RequestBody OrderQuery orderQuery) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderQuery.setPublishtime(ft.parse(orderQuery.getPublishTime()));
        List<Order> orders = orderService.queryOrder(orderQuery);
        return Result.success(orders);
    }
    @PostMapping("/")
    public Result createOrder(@RequestBody Order order){
        int insertCode = orderService.createOrder(order);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteOrder(@PathVariable int id){
        int deleteCode = orderService.deleteOrder(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @DeleteMapping("/delete/{ids}")
    public Result deleteOrders(@PathVariable List<Integer> ids){
        orderService.deleteOrders(ids);
        return Result.success("已删除选定订单！");
    }

    @PutMapping("/")
    public Result updateOrder(@RequestBody Order order){
        int updateCode = orderService.updateOrder(order);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}

