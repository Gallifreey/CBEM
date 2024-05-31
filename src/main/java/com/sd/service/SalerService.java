package com.sd.service;

import com.sd.entity.Saler;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【saler】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface SalerService extends IService<Saler> {
    List<Saler> getAllSaler();
    int createSaler(Saler saler);
    int deleteSaler(int id);
    int updateSaler(Saler saler);
}
