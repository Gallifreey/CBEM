package com.sd.mapper;

import com.sd.entity.Salerbank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalerbankMapper extends BaseMapper<Salerbank> {
    List<Salerbank> findAllSalerbank();
    int createSalerbank(Salerbank salerbank);
    int deleteSalerbank(int id);
    int updateSalerbank(Salerbank salerbank);
}