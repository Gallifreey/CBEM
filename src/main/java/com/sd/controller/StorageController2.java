package com.sd.controller;

import com.sd.entity.Commodity;
import com.sd.entity.Result;
import com.sd.entity.commodity.Query;
import com.sd.service.impl.CommodityServiceImpl;
import com.sd.service.impl.StorageServiceImpl;
import org.springframework.web.bind.annotation.*;

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
    public Result getAllStorages() {
        return Result.success(storageService.getAllStorage());
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
    @GetMapping("/commodity/list")
    public Result authStorage(@RequestParam int id){

        return Result.success();
    }
}
