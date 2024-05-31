package com.sd.service;

import com.sd.entity.Salerbank;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【salerbank】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface SalerbankService extends IService<Salerbank> {
    List<Salerbank> getAllSalerbank();
    int createSalerbank(Salerbank salerbank);
    int deleteSalerbank(int id);
    int updateSalerbank(Salerbank salerbank);
}
