package com.sd.service;

import com.sd.entity.Const;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【const】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface ConstService extends IService<Const> {
    List<Const> getAllConst();
    int createConst(Const constEntity);
    int deleteConst(int id);
    int updateConst(Const constEntity);
}
