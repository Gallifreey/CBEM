package com.sd.service;

import com.sd.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sd.entity.storage.QueryStorage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【storage】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface StorageService extends IService<Storage> {
    List<Storage> getStorageById(int id);
    int createStorage(Storage storage);
    int deleteStorage(int id);
    int updateStorage(Storage storage);
    int deleteStorages(List<Integer> ids);
    int authStorage(int id);
    int cancelAuth(int id);
    Storage listStorage(int id);
    List<Storage> queryStorage(QueryStorage queryStorage);
    List<Storage> searchStorage(QueryStorage queryStorage);
}
