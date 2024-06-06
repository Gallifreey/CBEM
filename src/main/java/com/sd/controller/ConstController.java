package com.sd.controller;

import com.sd.entity.Const;
import com.sd.entity.Result;
import com.sd.service.impl.ConstServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/const")
public class ConstController {
    private final ConstServiceImpl constEntityService;

    public ConstController(ConstServiceImpl constEntityService) {
        this.constEntityService = constEntityService;
    }

    @GetMapping("/")
    public Result getAllConsts() {
        return Result.success(constEntityService.getAllConst());
    }
    @PostMapping("/")
    public Result createConst(@RequestBody Const constEntity){
        int insertCode = constEntityService.createConst(constEntity);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteConst(@PathVariable int id){
        int deleteCode = constEntityService.deleteConst(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateConst(@RequestBody Const constEntity){
        int updateCode = constEntityService.updateConst(constEntity);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}
