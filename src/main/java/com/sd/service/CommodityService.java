package com.sd.service;

import com.sd.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【commodity】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface CommodityService extends IService<Commodity> {
    List<Commodity> getAllCommodity();
    int createCommodity(Commodity commodity);
    int deleteCommodity(int id);
    int updateCommodity(Commodity commodity);
}
