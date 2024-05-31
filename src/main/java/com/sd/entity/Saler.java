package com.sd.entity;

import java.io.Serializable;

/**
 * (Saler)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Saler implements Serializable {
    private static final long serialVersionUID = 892616909702844338L;
/**
     * 销售员主键
     */
    private Integer id;
/**
     * 门店ID外键
     */
    private Integer shopid;
/**
     * 销售员ID外键
     */
    private Integer salerid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getSalerid() {
        return salerid;
    }

    public void setSalerid(Integer salerid) {
        this.salerid = salerid;
    }

}

