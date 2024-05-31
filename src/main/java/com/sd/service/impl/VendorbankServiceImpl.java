package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Vendorbank;
import com.sd.service.VendorbankService;
import com.sd.mapper.VendorbankMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【vendorbank】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class VendorbankServiceImpl extends ServiceImpl<VendorbankMapper, Vendorbank>
        implements VendorbankService {

    private final VendorbankMapper vendorbankMapper;

    public VendorbankServiceImpl(VendorbankMapper vendorbankMapper) {
        this.vendorbankMapper = vendorbankMapper;
    }

    @Override
    public List<Vendorbank> getAllVendorbank() {
        return vendorbankMapper.findAllVendorbank();
    }

    @Override
    public int createVendorbank(Vendorbank vendorbank) {
        return vendorbankMapper.createVendorbank(vendorbank);
    }

    @Override
    public int deleteVendorbank(int id) {
        return vendorbankMapper.deleteVendorbank(id);
    }

    @Override
    public int updateVendorbank(Vendorbank vendorbank) {
        return vendorbankMapper.updateVendorbank(vendorbank);
    }
}