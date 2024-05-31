package com.sd.service;

import com.sd.entity.Vendor;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【vendor】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */
@Service
public interface VendorService extends IService<Vendor> {
    List<Vendor> getAllVendor();
    int createVendor(Vendor vendor);
    int deleteVendor(int id);
    int updateVendor(Vendor vendor);
}
