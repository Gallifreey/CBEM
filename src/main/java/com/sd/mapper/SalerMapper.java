package com.sd.mapper;

import com.sd.entity.Saler;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalerMapper extends BaseMapper<Saler> {
    List<Saler> findAllSaler();
    int createSaler(Saler saler);
    int deleteSaler(int id);
    int updateSaler(Saler saler);
}