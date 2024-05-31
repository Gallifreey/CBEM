package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Authorization;
import com.sd.service.AuthorizationService;
import com.sd.mapper.AuthorizationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 57555
* @description 针对表【authorization】的数据库操作Service实现
* @createDate 2024-05-22 15:20:37
*/
@Service
public class AuthorizationServiceImpl extends ServiceImpl<AuthorizationMapper, Authorization>
    implements AuthorizationService{
    private final AuthorizationMapper authorizationMapper;

    public AuthorizationServiceImpl(AuthorizationMapper authorizationMapper) {
        this.authorizationMapper = authorizationMapper;
    }

    @Override
    public List<Authorization> getAllAuthorization() {
        return authorizationMapper.findAllAuthorization();
    }

    @Override
    public int createAuthorization(Authorization authorization) {
        return authorizationMapper.createAuthorization(authorization);
    }

    @Override
    public int deleteAuthorization(int id) {
        return authorizationMapper.deleteAuthorization(id);
    }

    @Override
    public int updateAuthorization(Authorization authorization) {
        return authorizationMapper.updateAuthorization(authorization);
    }
}




