package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Result;
import com.sd.entity.Storage;
import com.sd.entity.storage.QueryStorage;
import com.sd.entity.storage.ReturnStorage;
import com.sd.service.StorageService;
import com.sd.mapper.StorageMapper;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 针对表【storage】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage>
        implements StorageService {

    private final StorageMapper storageMapper;

    public StorageServiceImpl(StorageMapper storageMapper) {
        this.storageMapper = storageMapper;
    }

    @Override
    public List<Storage> getStorageById(int id) {
        return storageMapper.findStorageById(id);
    }

    @Override
    public int createStorage(Storage storage) {
        return storageMapper.createStorage(storage);
    }

    @Override
    public int deleteStorage(int id) {
        return storageMapper.deleteStorage(id);
    }
    @Override
    public int deleteStorages(List<Integer> ids) {
        return storageMapper.deleteStorages(ids);
    }
    @Override
    public int updateStorage(Storage storage) {
        return storageMapper.updateStorage(storage);
    }

    @Override
    public int authStorage(int id){
        return storageMapper.addAuth(id);
    }

    @Override
    public int cancelAuth(int id){
        return storageMapper.cancelAuth(id);
    }
    @Override
    public Storage listStorage(int id){
        return storageMapper.listStorage(id);
    }

    @Override
    public List<Storage> queryStorage(QueryStorage queryStorage) {
        return storageMapper.queryStorage(queryStorage);
    }

    @Override
    public List<Storage> searchStorage(QueryStorage queryStorage) {
        return storageMapper.searchStorage(queryStorage);
    }
}