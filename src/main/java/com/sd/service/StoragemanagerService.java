package com.sd.service;

import com.sd.entity.Storagemanager;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【storagemanager】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface StoragemanagerService extends IService<Storagemanager> {
    List<Storagemanager> getAllStoragemanager();
    int createStoragemanager(Storagemanager storagemanager);
    int deleteStoragemanager(int id);
    int updateStoragemanager(Storagemanager storagemanager);
}
