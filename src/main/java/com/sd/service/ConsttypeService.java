package com.sd.service;

import com.sd.entity.Consttype;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【consttype】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface ConsttypeService extends IService<Consttype> {
    List<Consttype> getAllConsttype();
    int createConsttype(Consttype consttype);
    int deleteConsttype(int id);
    int updateConsttype(Consttype consttype);
}
