package com.sd.mapper;

import com.sd.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 57555
* @description 针对表【commodity】的数据库操作Mapper
* @createDate 2024-05-22 15:20:37
* @Entity entity.Commodity
*/
@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
    List<Commodity> findAllCommodity();
    int createCommodity(Commodity commodity);
    int deleteCommodity(int id);
    int updateCommodity(Commodity commodity);
    List<Commodity> findCommodityByUid(int uid);
    List<Commodity> findCommodityByNBDPS(Commodity commodity);
    void deleteCommodities(List<Integer> ids);
    Commodity findCommodityByID(int id);
}




