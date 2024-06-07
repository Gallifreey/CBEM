package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Storage;
import com.sd.service.StorageService;
import com.sd.mapper.StorageMapper;
import org.springframework.stereotype.Service;

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
    public List<Storage> getAllStorage() {
        return storageMapper.findAllStorage();
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
}