package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Storagemanager;
import com.sd.service.StoragemanagerService;
import com.sd.mapper.StoragemanagerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【storagemanager】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class StoragemanagerServiceImpl extends ServiceImpl<StoragemanagerMapper, Storagemanager>
        implements StoragemanagerService {

    private final StoragemanagerMapper storagemanagerMapper;

    public StoragemanagerServiceImpl(StoragemanagerMapper storagemanagerMapper) {
        this.storagemanagerMapper = storagemanagerMapper;
    }

    @Override
    public List<Storagemanager> getAllStoragemanager() {
        return storagemanagerMapper.findAllStoragemanager();
    }

    @Override
    public int createStoragemanager(Storagemanager storagemanager) {
        return storagemanagerMapper.createStoragemanager(storagemanager);
    }

    @Override
    public int deleteStoragemanager(int id) {
        return storagemanagerMapper.deleteStoragemanager(id);
    }

    @Override
    public int updateStoragemanager(Storagemanager storagemanager) {
        return storagemanagerMapper.updateStoragemanager(storagemanager);
    }
}