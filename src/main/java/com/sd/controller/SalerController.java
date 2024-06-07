package com.sd.controller;

import com.sd.entity.Saler;
import com.sd.entity.Result;
import com.sd.entity.saler.InfoData;
import com.sd.entity.saler.Ledger;
import com.sd.entity.saler.PaymentData;
import com.sd.service.impl.SalerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/saler")
public class SalerController {
    private final SalerServiceImpl salerService;

    public SalerController(SalerServiceImpl salerService) {
        this.salerService = salerService;
    }

    @GetMapping("/")
    public Result getAllSalers() {
        return Result.success(salerService.getAllSaler());
    }
    @PostMapping("/")
    public Result createSaler(@RequestBody Saler saler){
        int insertCode = salerService.createSaler(saler);
        if (insertCode == 1){
            return Result.success("创建成功！");
        }
        return Result.error("创建失败！");
    }
    @DeleteMapping("/{id}")
    public Result deleteSaler(@PathVariable int id){
        int deleteCode = salerService.deleteSaler(id);
        if (deleteCode == 1){
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }
    @PutMapping("/")
    public Result updateSaler(@RequestBody Saler saler){
        int updateCode = salerService.updateSaler(saler);
        if(updateCode == 1){
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }
    @GetMapping("/statistics/bussiness")
    public Result ledger(@RequestParam int id){
        int count = (int) (Math.random()*100) + 1;
        List<PaymentData> paymentDataList = new ArrayList<>();
        List<InfoData> infoDataList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            PaymentData paymentData = new PaymentData();
            int hh = (int) (Math.random()*24) + 1;
            int mm = (int) (Math.random()*60);
            String time = String.format("%02d:%02d", hh, mm);
            double price = Math.random()*1000;
            String formattedPrice = String.format("%.2f", price);
            price = Double.parseDouble(formattedPrice);
            paymentData.setDate(time);
            paymentData.setPrice(price);
            paymentData.setType("today");
            paymentDataList.add(paymentData);
        }
        Ledger ledger = new Ledger();
        ledger.setPaymentDataList(paymentDataList);
        return  Result.success(ledger);
    }
}
