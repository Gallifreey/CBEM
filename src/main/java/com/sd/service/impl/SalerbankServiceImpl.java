package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Salerbank;
import com.sd.service.SalerbankService;
import com.sd.mapper.SalerbankMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【salerbank】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class SalerbankServiceImpl extends ServiceImpl<SalerbankMapper, Salerbank>
        implements SalerbankService {

    private final SalerbankMapper salerbankMapper;

    public SalerbankServiceImpl(SalerbankMapper salerbankMapper) {
        this.salerbankMapper = salerbankMapper;
    }

    @Override
    public List<Salerbank> getAllSalerbank() {
        return salerbankMapper.findAllSalerbank();
    }

    @Override
    public int createSalerbank(Salerbank salerbank) {
        return salerbankMapper.createSalerbank(salerbank);
    }

    @Override
    public int deleteSalerbank(int id) {
        return salerbankMapper.deleteSalerbank(id);
    }

    @Override
    public int updateSalerbank(Salerbank salerbank) {
        return salerbankMapper.updateSalerbank(salerbank);
    }
}