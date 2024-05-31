package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Shop;
import com.sd.service.impl.ShopServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shop")
public class ShopController {
    private final ShopServiceImpl shopService;

    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public Result getAllShops() {
        return Result.success(shopService.getAllShop());
    }
    @PostMapping("/")
    public Result createShop(@RequestBody Shop shop){
        int insertCode = shopService.createShop(shop);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteShop(@PathVariable int id){
        int deleteCode = shopService.deleteShop(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateShop(@RequestBody Shop shop){
        int updateCode = shopService.updateShop(shop);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}