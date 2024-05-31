package com.sd.mapper;

import com.sd.entity.Const;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConstMapper extends BaseMapper<Const> {
    List<Const> findAllConst();
    int createConst(Const constValue);
    int deleteConst(int id);
    int updateConst(Const constValue);
}