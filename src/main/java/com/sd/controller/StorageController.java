package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Storage;
import com.sd.service.impl.StorageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
    private final StorageServiceImpl storageService;

    public StorageController(StorageServiceImpl storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public Result getAllStorages() {
        return Result.success(storageService.getAllStorage());
    }
    @PostMapping("/")
    public Result createStorage(@RequestBody Storage storage){
        int insertCode = storageService.createStorage(storage);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteStorage(@PathVariable int id){
        int deleteCode = storageService.deleteStorage(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateStorage(@RequestBody Storage storage){
        int updateCode = storageService.updateStorage(storage);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}