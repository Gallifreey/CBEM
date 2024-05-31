package com.sd.mapper;

import com.sd.entity.Storagebank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoragebankMapper extends BaseMapper<Storagebank> {
    List<Storagebank> findAllStoragebank();
    int createStoragebank(Storagebank storagebank);
    int deleteStoragebank(int id);
    int updateStoragebank(Storagebank storagebank);
}