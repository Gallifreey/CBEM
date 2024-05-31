package com.sd.service;

import com.sd.entity.Storagebank;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【storagebank】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface StoragebankService extends IService<Storagebank> {
    List<Storagebank> getAllStoragebank();
    int createStoragebank(Storagebank storagebank);
    int deleteStoragebank(int id);
    int updateStoragebank(Storagebank storagebank);
}
