package com.sd.controller;

import com.sd.entity.Commodity;
import com.sd.entity.Result;
import com.sd.service.impl.CommodityServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/commoditiy")
public class CommodityController {
    private final CommodityServiceImpl commodityService;

    public CommodityController(CommodityServiceImpl commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/")
    public Result getAllCommoditys() {
        return Result.success(commodityService.getAllCommodity());
    }
    @PostMapping("/")
    public Result createCommodity(@RequestBody Commodity commodity){
        int insertCode = commodityService.createCommodity(commodity);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteCommodity(@PathVariable int id){
        int deleteCode = commodityService.deleteCommodity(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateCommodity(@RequestBody Commodity commodity){
        int updateCode = commodityService.updateCommodity(commodity);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}
