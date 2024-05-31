package com.sd.mapper;

import com.sd.entity.Vendor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VendorMapper extends BaseMapper<Vendor> {
    List<Vendor> findAllVendor();
    int createVendor(Vendor vendor);
    int deleteVendor(int id);
    int updateVendor(Vendor vendor);
}