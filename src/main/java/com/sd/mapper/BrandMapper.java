package com.sd.mapper;

import com.sd.entity.Brand;
import com.sd.entity.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 57555
* @description 针对表【brand】的数据库操作Mapper
* @createDate 2024-05-22 15:20:37
* @Entity entity.Brand
*/
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {
    public List<Brand> findAllBrand();
    public int createBrand(Brand brand);
    public int deleteBrand(int id);
    public int updateBrand(Brand brand);
}




