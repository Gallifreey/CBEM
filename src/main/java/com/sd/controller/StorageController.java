package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Storage;
import com.sd.service.impl.StorageServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vendor/storage")
public class StorageController {
    private final StorageServiceImpl storageService;

    public StorageController(StorageServiceImpl storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public Result getAllStorages() {
        return Result.success(storageService.getAllStorage());
    }
//    @GetMapping("/list")
//    public Result getStorageByID(@RequestParam int uid) {
//        return Result.success(storageService.getStorageByID());
//    }
//    @PostMapping("/query")
//    public Result getStorageByID(@RequestBody Storage storage) {
//        return Result.success(storageService.());
//    }
    @PostMapping("/auth")
    public Result auth(@RequestBody Map<String, Object> jsonMap){
        Integer sid = (Integer) jsonMap.get("sid");
        Integer bid = (Integer) jsonMap.get("bid");

        return Result.success();
    }
    @PostMapping("/")
    public Result createStorage(@RequestBody Storage storage){
        int insertCode = storageService.createStorage(storage);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/delete")
    public Result deleteCommodities(@RequestParam List<Integer> ids){
        storageService.deleteStorages(ids);
        return Result.success("已删除选定商品！");
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