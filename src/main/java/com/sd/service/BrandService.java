package com.sd.service;

import com.sd.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【brand】的数据库操作Service
 * @createDate 2024-05-22 15:20:37
 */

@Service
public interface BrandService extends IService<Brand> {
    List<Brand> getAllBrand();
    int createBrand(Brand brand);
    int deleteBrand(int id);
    int updateBrand(Brand brand);
}
