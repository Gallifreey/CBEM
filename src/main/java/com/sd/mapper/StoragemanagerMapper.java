package com.sd.mapper;

import com.sd.entity.Storagemanager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoragemanagerMapper extends BaseMapper<Storagemanager> {
    List<Storagemanager> findAllStoragemanager();
    int createStoragemanager(Storagemanager storagemanager);
    int deleteStoragemanager(int id);
    int updateStoragemanager(Storagemanager storagemanager);
}