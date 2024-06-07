package com.sd.mapper;

import com.sd.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    List<Storage> findAllStorage();
    int createStorage(Storage storage);
    int deleteStorage(int id);
    int updateStorage(Storage storage);
    int deleteStorages(List<Integer> ids);
}