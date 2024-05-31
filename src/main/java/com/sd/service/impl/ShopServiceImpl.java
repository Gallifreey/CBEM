package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Shop;
import com.sd.service.ShopService;
import com.sd.mapper.ShopMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【shop】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
        implements ShopService {

    private final ShopMapper shopMapper;

    public ShopServiceImpl(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Override
    public List<Shop> getAllShop() {
        return shopMapper.findAllShop();
    }

    @Override
    public int createShop(Shop shop) {
        return shopMapper.createShop(shop);
    }

    @Override
    public int deleteShop(int id) {
        return shopMapper.deleteShop(id);
    }

    @Override
    public int updateShop(Shop shop) {
        return shopMapper.updateShop(shop);
    }
}