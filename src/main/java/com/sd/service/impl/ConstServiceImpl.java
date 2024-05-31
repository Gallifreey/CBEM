package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Const;
import com.sd.service.ConstService;
import com.sd.mapper.ConstMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【const】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class ConstServiceImpl extends ServiceImpl<ConstMapper, Const> implements ConstService {

    private final ConstMapper constMapper;

    public ConstServiceImpl(ConstMapper constMapper) {
        this.constMapper = constMapper;
    }

    @Override
    public List<Const> getAllConst() {
        return constMapper.findAllConst();
    }

    @Override
    public int createConst(Const constEntity) {
        return constMapper.createConst(constEntity);
    }

    @Override
    public int deleteConst(int id) {
        return constMapper.deleteConst(id);
    }

    @Override
    public int updateConst(Const constEntity) {
        return constMapper.updateConst(constEntity);
    }
}
