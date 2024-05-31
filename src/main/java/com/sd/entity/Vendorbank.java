package com.sd.entity;

import java.io.Serializable;

/**
 * (Vendorbank)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Vendorbank implements Serializable {
    private static final long serialVersionUID = -80184157590649075L;
/**
     * 供货商商品表主键
     */
    private Integer id;
/**
     * 商品外键
     */
    private Integer commodityid;
/**
     * 供货商外键
     */
    private Integer vendorid;


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

    public Integer getVendorid() {
        return vendorid;
    }

    public void setVendorid(Integer vendorid) {
        this.vendorid = vendorid;
    }

}

