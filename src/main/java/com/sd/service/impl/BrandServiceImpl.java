package com.sd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sd.entity.Brand;
import com.sd.service.BrandService;
import com.sd.mapper.BrandMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【brand】的数据库操作Service实现
 * @createDate 2024-05-22 15:20:37
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandMapper.findAllBrand();
    }

    @Override
    public int createBrand(Brand brand) {
        return brandMapper.createBrand(brand);
    }

    @Override
    public int deleteBrand(int id) {
        return brandMapper.deleteBrand(id);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }
}
