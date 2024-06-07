package com.sd.controller;

import com.sd.entity.Brand;
import com.sd.entity.Result;
import com.sd.service.impl.BrandServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    private final BrandServiceImpl brandService;

    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/list")
    public Result getAllBrands() {
        return Result.success(brandService.getAllBrand());
    }
    @PostMapping("/")
    public Result createBrand(@RequestBody Brand brand){
        int insertCode = brandService.createBrand(brand);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteBrand(@PathVariable int id){
        int deleteCode = brandService.deleteBrand(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateBrand(@RequestBody Brand brand){
        int updateCode = brandService.updateBrand(brand);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}
