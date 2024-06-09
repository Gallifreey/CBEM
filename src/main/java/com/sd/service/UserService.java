package com.sd.service;

import com.sd.entity.Token;
import com.sd.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface UserService extends IService<User> {
    List<User> getAllUser();
    int createUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    Token checkUP(String username);
    User getByUsername(String username);
}
