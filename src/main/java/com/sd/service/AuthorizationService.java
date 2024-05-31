package com.sd.service;

import com.sd.entity.Authorization;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 57555
* @description 针对表【authorization】的数据库操作Service
* @createDate 2024-05-22 15:20:37
*/
@Service
public interface AuthorizationService extends IService<Authorization> {
    public List<Authorization> getAllAuthorization();
    public int createAuthorization(Authorization authorization);
    public int deleteAuthorization(int id);
    public int updateAuthorization(Authorization authorization);
}
