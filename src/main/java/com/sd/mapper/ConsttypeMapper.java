package com.sd.mapper;

import com.sd.entity.Consttype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsttypeMapper extends BaseMapper<Consttype> {
    List<Consttype> findAllConsttype();
    int createConsttype(Consttype consttype);
    int deleteConsttype(int id);
    int updateConsttype(Consttype consttype);
}