package com.sd.entity;

import java.io.Serializable;

/**
 * (Salerbank)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Salerbank implements Serializable {
    private static final long serialVersionUID = -21452264169063700L;
/**
     * 销售员商品仓库主键
     */
    private Integer id;
/**
     * 商品外键
     */
    private Integer commodityid;
/**
     * 销售员外键
     */
    private Integer salerid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public Integer getSalerid() {
        return salerid;
    }

    public void setSalerid(Integer salerid) {
        this.salerid = salerid;
    }

}

