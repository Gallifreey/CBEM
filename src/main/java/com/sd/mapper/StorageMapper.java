package com.sd.mapper;

import com.sd.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sd.entity.storage.QueryStorage;
import com.sd.entity.storage.ReturnStorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    List<Storage> findStorageById(int id);
    int createStorage(Storage storage);
    int deleteStorage(int id);
    int updateStorage(Storage storage);
    int deleteStorages(List<Integer> ids);

    int addAuth(int id);
    int cancelAuth(int id);
    Storage listStorage(int id);
    List<Storage> queryStorage(QueryStorage queryStorage);
    List<Storage> searchStorage(QueryStorage queryStorage);
}