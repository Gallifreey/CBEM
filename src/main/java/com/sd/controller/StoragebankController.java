package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Storagebank;
import com.sd.service.impl.StoragebankServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/storagebank")
public class StoragebankController {
    private final StoragebankServiceImpl storagebankService;

    public StoragebankController(StoragebankServiceImpl storagebankService) {
        this.storagebankService = storagebankService;
    }

    @GetMapping("/")
    public Result getAllStoragebanks() {
        return Result.success(storagebankService.getAllStoragebank());
    }
    @PostMapping("/")
    public Result createStoragebank(@RequestBody Storagebank storagebank){
        int insertCode = storagebankService.createStoragebank(storagebank);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteStoragebank(@PathVariable int id){
        int deleteCode = storagebankService.deleteStoragebank(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateStoragebank(@RequestBody Storagebank storagebank){
        int updateCode = storagebankService.updateStoragebank(storagebank);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}