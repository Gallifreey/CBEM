package com.sd.controller;

import com.sd.entity.Commodity;
import com.sd.entity.Result;
import com.sd.entity.commodity.*;
import com.sd.service.impl.CommodityServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor/commodity")
public class CommodityController2 {
    private final CommodityServiceImpl commodityService;

    public CommodityController2(CommodityServiceImpl commodityService) {
        this.commodityService = commodityService;
    }
    @GetMapping("/list")
    public Result findCommodityByUid(@RequestParam int uid){
        List<Commodity> list = commodityService.findCommodityByUid(uid);
        for (Commodity commodity:list) {
            commodity.setKey(commodity.getId());
        }
        return Result.success(list);
    }
    @PostMapping("/query")
    public Result queryCommodity(@RequestBody Commodity commodity){
        List<Commodity> list = commodityService.findCommodityByNBDPS(commodity);
        for (Commodity commodity1:list) {
            commodity1.setKey(commodity1.getId());
        }
        return Result.success(list);
    }

//    http://10.206.170.134:8080/api/vendor/commodity/delete?ids=591,592
    @DeleteMapping("/delete")
    public Result deleteCommodities(@RequestParam List<Integer> ids){
        commodityService.deleteCommodities(ids);
        return Result.success("已删除选定商品！");
    }
    @GetMapping("/details")
    public Result getDetails(@RequestParam int id){
        Commodity commodity = commodityService.findCommodityByID(id);
        Details details = new Details();
        details.setSku(new Sku(commodity));
        details.setBasicInfo(new BasicInfo(commodity));
        details.setBom(new Bom(commodity));
        details.setMeta(new Meta(commodity));
        return Result.success(details);
    }
    @PostMapping("/add")
    public Result addCommodity(@RequestBody Details details){
        int addCode = commodityService.addCommodity(details);
        if(addCode == 1){
            return Result.success("添加成功！");
        }
        return Result.error("添加失败！");
    }
    @PostMapping("/modify")
    public Result modifyCommodity(@RequestBody Details details){
        Commodity commodity = new Commodity();
        commodity.setDetails(details);
        int updateCode = commodityService.updateCommodity(commodity);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败!");
    }
}