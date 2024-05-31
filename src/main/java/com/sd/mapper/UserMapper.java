package com.sd.mapper;

import com.sd.entity.Token;
import com.sd.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> findAllUser();
    int createUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    Token checkUP(String username);
}