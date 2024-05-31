package com.sd.controller;

import com.sd.entity.Result;
import com.sd.entity.Salerbank;
import com.sd.service.impl.SalerbankServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salerbank")
public class SalerbankController {
    private final SalerbankServiceImpl salerbankService;

    public SalerbankController(SalerbankServiceImpl salerbankService) {
        this.salerbankService = salerbankService;
    }

    @GetMapping("/")
    public Result getAllSalerbanks() {
        return Result.success(salerbankService.getAllSalerbank());
    }
    @PostMapping("/")
    public Result createSalerbank(@RequestBody Salerbank saler){
        int insertCode = salerbankService.createSalerbank(saler);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteSalerbank(@PathVariable int id){
        int deleteCode =salerbankService.deleteSalerbank(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateSalerbank(@RequestBody Salerbank saler){
        int updateCode = salerbankService.updateSalerbank(saler);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
}

