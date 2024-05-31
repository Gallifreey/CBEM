package com.sd.mapper;

import com.sd.entity.Vendorbank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VendorbankMapper extends BaseMapper<Vendorbank> {
    List<Vendorbank> findAllVendorbank();
    int createVendorbank(Vendorbank vendorbank);
    int deleteVendorbank(int id);
    int updateVendorbank(Vendorbank vendorbank);
}