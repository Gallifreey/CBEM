package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Saler;
import com.sd.service.SalerService;
import com.sd.mapper.SalerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【saler】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class SalerServiceImpl extends ServiceImpl<SalerMapper, Saler>
        implements SalerService {

    private final SalerMapper salerMapper;

    public SalerServiceImpl(SalerMapper salerMapper) {
        this.salerMapper = salerMapper;
    }

    @Override
    public List<Saler> getAllSaler() {
        return salerMapper.findAllSaler();
    }

    @Override
    public int createSaler(Saler saler) {
        return salerMapper.createSaler(saler);
    }

    @Override
    public int deleteSaler(int id) {
        return salerMapper.deleteSaler(id);
    }

    @Override
    public int updateSaler(Saler saler) {
        return salerMapper.updateSaler(saler);
    }
}