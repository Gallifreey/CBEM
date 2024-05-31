package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Vendor;
import com.sd.service.VendorService;
import com.sd.mapper.VendorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【vendor】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class VendorServiceImpl extends ServiceImpl<VendorMapper, Vendor>
        implements VendorService {

    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorMapper vendorMapper) {
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<Vendor> getAllVendor() {
        return vendorMapper.findAllVendor();
    }

    @Override
    public int createVendor(Vendor vendor) {
        return vendorMapper.createVendor(vendor);
    }

    @Override
    public int deleteVendor(int id) {
        return vendorMapper.deleteVendor(id);
    }

    @Override
    public int updateVendor(Vendor vendor) {
        return vendorMapper.updateVendor(vendor);
    }
}