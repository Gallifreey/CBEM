package com.sd.controller;
import com.sd.entity.Authorization;
import com.sd.entity.Result;
import com.sd.service.impl.AuthorizationServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authorizations")
public class AuthorizationController {
    private final AuthorizationServiceImpl authorizationService;

    public AuthorizationController(AuthorizationServiceImpl authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/")
    public Result getAllAuthorizations() {
        return Result.success(authorizationService.getAllAuthorization());
    }
    @PostMapping("/")
    public Result createAuthorization(@RequestBody Authorization authorization){
        int insertCode = authorizationService.createAuthorization(authorization);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteAuthorization(@PathVariable int id){
        int deleteCode = authorizationService.deleteAuthorization(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateAuthorization(@RequestBody Authorization authorization){
        int updateCode = authorizationService.updateAuthorization(authorization);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}
