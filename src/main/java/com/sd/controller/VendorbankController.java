package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Vendorbank;
import com.sd.service.impl.VendorbankServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendorbank")
public class VendorbankController {
    private final VendorbankServiceImpl vendorbankService;

    public VendorbankController(VendorbankServiceImpl vendorbankService) {
        this.vendorbankService = vendorbankService;
    }

    @GetMapping("/")
    public Result getAllVendorbanks() {
        return Result.success(vendorbankService.getAllVendorbank());
    }
    @PostMapping("/")
    public Result createVendorbank(@RequestBody Vendorbank vendorbank){
        int insertCode = vendorbankService.createVendorbank(vendorbank);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteVendorbank(@PathVariable int id){
        int deleteCode = vendorbankService.deleteVendorbank(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateVendorbank(@RequestBody Vendorbank vendorbank){
        int updateCode = vendorbankService.updateVendorbank(vendorbank);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}