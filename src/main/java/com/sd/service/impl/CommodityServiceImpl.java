package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Commodity;
import com.sd.service.CommodityService;
import com.sd.mapper.CommodityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【commodity】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {

    private final CommodityMapper commodityMapper;

    public CommodityServiceImpl(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    @Override
    public List<Commodity> getAllCommodity() {
        return commodityMapper.findAllCommodity();
    }

    @Override
    public int createCommodity(Commodity commodity) {
        return commodityMapper.createCommodity(commodity);
    }

    @Override
    public int deleteCommodity(int id) {
        return commodityMapper.deleteCommodity(id);
    }

    @Override
    public int updateCommodity(Commodity commodity) {
        return commodityMapper.updateCommodity(commodity);
    }

    @Override
    public List<Commodity> findCommodityByUid(int uid){
        return commodityMapper.findCommodityByUid(uid);
    }
    @Override
    public List<Commodity> findCommodityByNBDPS(Commodity commodity){
        return commodityMapper.findCommodityByNBDPS(commodity);
    }

    @Override
    public void deleteCommodities(List<Integer> ids) {
        commodityMapper.deleteCommodities(ids);
    }

    @Override
    public Commodity findCommodityByID(int id) {
        return commodityMapper.findCommodityByID(id);
    }

}
