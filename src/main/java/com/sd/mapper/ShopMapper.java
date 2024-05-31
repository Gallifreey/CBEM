package com.sd.mapper;

import com.sd.entity.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper extends BaseMapper<Shop> {
    List<Shop> findAllShop();
    int createShop(Shop shop);
    int deleteShop(int id);
    int updateShop(Shop shop);
}