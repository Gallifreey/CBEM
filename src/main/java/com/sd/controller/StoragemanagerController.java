package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Storagemanager;
import com.sd.service.impl.StoragemanagerServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/storagemanager")
public class StoragemanagerController {
    private final StoragemanagerServiceImpl storagemanagerService;

    public StoragemanagerController(StoragemanagerServiceImpl storagemanagerService) {
        this.storagemanagerService = storagemanagerService;
    }

    @GetMapping("/")
    public Result getAllStoragemanagers() {
        return Result.success(storagemanagerService.getAllStoragemanager());
    }
    @PostMapping("/")
    public Result createStoragemanager(@RequestBody Storagemanager storagemanager){
        int insertCode = storagemanagerService.createStoragemanager(storagemanager);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteStoragemanager(@PathVariable int id){
        int deleteCode = storagemanagerService.deleteStoragemanager(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateStoragemanager(@RequestBody Storagemanager storagemanager){
        int updateCode = storagemanagerService.updateStoragemanager(storagemanager);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}