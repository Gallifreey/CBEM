package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Token;
import com.sd.entity.User;
import com.sd.service.UserService;
import com.sd.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Token checkUP(String username) {
        return userMapper.checkUP(username);
    }
}