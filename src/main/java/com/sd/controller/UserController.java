package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Token;
import com.sd.entity.User;
import com.sd.service.impl.UserServiceImpl;
import com.sd.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Result getAllUsers() {
        return Result.success(userService.getAllUser());
    }
    @PostMapping("/")
    public Result createUser(@RequestBody User user){
        int insertCode = userService.createUser(user);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @GetMapping("/info")
    public Result searchUserByUsername(@RequestParam String username){
        User user = userService.getByUsername(username);
        return Result.success(user);
    }
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable int id){
        int deleteCode = userService.deleteUser(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateUser(@RequestBody User user){
        int updateCode = userService.updateUser(user);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
    // 登录
    @PostMapping("/login")
    public Result Login(@RequestBody User user){
        Token token1 = userService.checkUP(user.getUsername());
        if(token1.getPassword().equals(user.getPassword())){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", user.getUsername());
            String token = JwtUtils.generateJwt(claims);
            token1.setToken(token);
            token1.setPassword("");
            return Result.success(token1);
        }
    return Result.error("用户名或密码错误！");
    }
}