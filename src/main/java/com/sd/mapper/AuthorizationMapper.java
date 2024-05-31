package com.sd.mapper;

import com.sd.entity.Authorization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 57555
* @description 针对表【authorization】的数据库操作Mapper
* @createDate 2024-05-22 15:20:37
* @Entity entity.Authorization
*/
@Mapper
public interface AuthorizationMapper extends BaseMapper<Authorization> {
    public List<Authorization> findAllAuthorization();
    public int createAuthorization(Authorization authorization);
    public int deleteAuthorization(int id);
    public int updateAuthorization(Authorization authorization);
}




