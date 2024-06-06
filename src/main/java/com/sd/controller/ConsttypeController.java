package com.sd.controller;

import com.sd.entity.Consttype;
import com.sd.entity.Result;
import com.sd.service.impl.ConsttypeServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consttype")
public class ConsttypeController {
    private final ConsttypeServiceImpl consttypeService;

    public ConsttypeController(ConsttypeServiceImpl consttypeService) {
        this.consttypeService = consttypeService;
    }

    @GetMapping("/")
    public Result getAllConsttypes() {
        return Result.success(consttypeService.getAllConsttype());
    }
    @PostMapping("/")
    public Result createConsttype(@RequestBody Consttype consttype){
        int insertCode = consttypeService.createConsttype(consttype);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteConsttype(@PathVariable int id){
        int deleteCode = consttypeService.deleteConsttype(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateConsttype(@RequestBody Consttype consttype){
        int updateCode = consttypeService.updateConsttype(consttype);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}
