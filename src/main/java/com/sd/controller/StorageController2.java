package com.sd.controller;

import com.sd.entity.Brand;
import com.sd.entity.Commodity;
import com.sd.entity.Result;
import com.sd.entity.Storage;
import com.sd.entity.commodity.Query;
import com.sd.entity.storage.QueryStorage;
import com.sd.entity.storage.ReturnStorage;
import com.sd.service.impl.CommodityServiceImpl;
import com.sd.service.impl.StorageServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageController2 {
    private final StorageServiceImpl storageService;
    private final CommodityServiceImpl commodityService;
    public StorageController2(StorageServiceImpl storageService,CommodityServiceImpl commodityService) {
        this.storageService = storageService;
        this.commodityService = commodityService;
    }
    @GetMapping("/list")
    public Result getStorageById(@RequestParam int id) {
        List<Storage> storageList = storageService.getStorageById(id);
        List<ReturnStorage> returnStorageList = new ArrayList<>();
        for (Storage storage:storageList) {
            ReturnStorage storage1 = new ReturnStorage();
            storage1.setAddress(storage.getAddress());
            storage1.setName(storage.getName());
            storage1.setKey(storage.getId());
            storage1.setAuthTime(storage.getAuthTime().toString());
            returnStorageList.add(storage1);
        }
        return Result.success(returnStorageList);
    }
    @PostMapping("/query")
    public Result searchStorage(@RequestBody QueryStorage queryStorage){
        String[] authTime = queryStorage.getAuthTime();
        if(authTime != null && authTime.length >= 2){
            queryStorage.setBelowTime(authTime[0]);
            queryStorage.setTopTime(authTime[1]);
        }
        List<Storage> storageList = storageService.searchStorage(queryStorage);
        List<ReturnStorage> returnStorageList = new ArrayList<>();
        for (Storage storage:storageList) {
            ReturnStorage storage1 = new ReturnStorage();
            storage1.setAddress(storage.getAddress());
            storage1.setName(storage.getName());
            storage1.setKey(storage.getId());
            storage1.setAuthTime(storage.getAuthTime().toString());
            returnStorageList.add(storage1);
        }
        return Result.success(returnStorageList);
    }

    @PostMapping("/commodity/add")
    public Result addCommodity(@RequestBody Commodity commodity) {
        commodityService.createCommodity(commodity);
        return Result.success();
    }
    @PostMapping("/commodity/modify")
    public Result modifyCommodity(@RequestBody Commodity commodity) {
        commodityService.updateCommodity(commodity);
        return Result.success();
    }
    @DeleteMapping("/commodity/delete")
    public Result deleteCommodity(@RequestParam List<Integer> ids) {
        commodityService.deleteCommodities(ids);
        return Result.success("已删除选定商品！");
    }
    @PostMapping("/commodity/query")
    public Result queryCommodity(@RequestBody Commodity commodity){
        List<Commodity> commodityList = commodityService.findCommodityByNBDPS(commodity);
        return Result.success(commodityList);
    }
    @GetMapping("/commodity/list")
    public Result findCommodityByUid(@RequestParam int id){
        List<Commodity> list = commodityService.findCommodityBySid(id);
        return Result.success(list);
    }
    @GetMapping("/brand/auth")
    public Result authStorage(@RequestParam int id){
        int authCode = storageService.authStorage(id);
        return Result.success(authCode);
    }
    @GetMapping("/brand/cancel")
    public Result cancelAuth(@RequestParam int id){
        int cancelCode = storageService.cancelAuth(id);
        return Result.success(cancelCode);
    }
    @GetMapping("/brand/list")
    public Result listStorage(@RequestParam int id){
        Storage storage = storageService.listStorage(id);
        return Result.success(storage);
    }
    @PostMapping("/brand/query")
    public Result queryStorage(@RequestBody QueryStorage queryStorage){
        String[] authTime = queryStorage.getAuthTime();
        if(authTime != null && authTime.length >= 2){
            queryStorage.setBelowTime(authTime[0]);
            queryStorage.setTopTime(authTime[1]);
        }
        List<Storage> storageList = storageService.queryStorage(queryStorage);
        List<ReturnStorage> returnStorages = new ArrayList<>();
        for (Storage storage : storageList) {
            ReturnStorage returnStorage = new ReturnStorage();
            returnStorage.setKey(storage.getId());
            returnStorage.setName(storage.getName());
            returnStorage.setAuthTime(storage.getAuthTime().toString());
            returnStorage.setPicture(storage.getPicture());
            returnStorages.add(returnStorage);
        }
        return Result.success(returnStorages);
    }
}
