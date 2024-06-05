package com.sd.controller;

import com.sd.entity.Commodity;
import com.sd.entity.Result;
import com.sd.service.impl.CommodityServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vendor/commodity")
public class CommodityController2 {
    private final CommodityServiceImpl commodityService;

    public CommodityController2(CommodityServiceImpl commodityService) {
        this.commodityService = commodityService;
    }
    @GetMapping("/list")
    public Result findCommodityByUid(@RequestParam int uid){
        List<Commodity> list = commodityService.findCommodityByUid(uid);
        return Result.success(list);
    }
    @PostMapping("/query")
    public Result queryCommodity(@RequestBody Commodity commodity){
        List<Commodity> list = commodityService.findCommodityByNBDPS(commodity);
        return Result.success(list);
    }
}
