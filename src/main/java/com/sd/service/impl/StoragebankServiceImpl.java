package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Storagebank;
import com.sd.service.StoragebankService;
import com.sd.mapper.StoragebankMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【storagebank】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class StoragebankServiceImpl extends ServiceImpl<StoragebankMapper, Storagebank>
        implements StoragebankService {

    private final StoragebankMapper storagebankMapper;

    public StoragebankServiceImpl(StoragebankMapper storagebankMapper) {
        this.storagebankMapper = storagebankMapper;
    }

    @Override
    public List<Storagebank> getAllStoragebank() {
        return storagebankMapper.findAllStoragebank();
    }

    @Override
    public int createStoragebank(Storagebank storagebank) {
        return storagebankMapper.createStoragebank(storagebank);
    }

    @Override
    public int deleteStoragebank(int id) {
        return storagebankMapper.deleteStoragebank(id);
    }

    @Override
    public int updateStoragebank(Storagebank storagebank) {
        return storagebankMapper.updateStoragebank(storagebank);
    }
}