package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Consttype;
import com.sd.service.ConsttypeService;
import com.sd.mapper.ConsttypeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【consttype】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class ConsttypeServiceImpl extends ServiceImpl<ConsttypeMapper, Consttype>
        implements ConsttypeService {

    private final ConsttypeMapper consttypeMapper;

    public ConsttypeServiceImpl(ConsttypeMapper consttypeMapper) {
        this.consttypeMapper = consttypeMapper;
    }

    @Override
    public List<Consttype> getAllConsttype() {
        return consttypeMapper.findAllConsttype();
    }

    @Override
    public int createConsttype(Consttype consttype) {
        return consttypeMapper.createConsttype(consttype);
    }

    @Override
    public int deleteConsttype(int id) {
        return consttypeMapper.deleteConsttype(id);
    }

    @Override
    public int updateConsttype(Consttype consttype) {
        return consttypeMapper.updateConsttype(consttype);
    }
}