package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Vendor;
import com.sd.service.impl.VendorServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/")
    public Result getAllVendors() {
        return Result.success(vendorService.getAllVendor());
    }
    @PostMapping("/")
    public Result createVendor(@RequestBody Vendor vendor){
        int insertCode = vendorService.createVendor(vendor);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteVendor(@PathVariable int id){
        int deleteCode = vendorService.deleteVendor(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateVendor(@RequestBody Vendor vendor){
        int updateCode = vendorService.updateVendor(vendor);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}