package com.sd.service;

import com.sd.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【storage】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface StorageService extends IService<Storage> {
    List<Storage> getAllStorage();
    int createStorage(Storage storage);
    int deleteStorage(int id);
    int updateStorage(Storage storage);
    int deleteStorages(List<Integer> ids);
}
