package com.sd.service;

import com.sd.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【shop】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface ShopService extends IService<Shop> {
    List<Shop> getAllShop();
    int createShop(Shop shop);
    int deleteShop(int id);
    int updateShop(Shop shop);
}
