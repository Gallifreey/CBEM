package com.sd.service;

import com.sd.entity.Vendorbank;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【vendorbank】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface VendorbankService extends IService<Vendorbank> {
    List<Vendorbank> getAllVendorbank();
    int createVendorbank(Vendorbank vendorbank);
    int deleteVendorbank(int id);
    int updateVendorbank(Vendorbank vendorbank);
}
