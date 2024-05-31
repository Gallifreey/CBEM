package com.sd.entity;

import java.io.Serializable;

/**
 * (Storagebank)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Storagebank implements Serializable {
    private static final long serialVersionUID = 391826516780089413L;
/**
     * 库存表主键
     */
    private Integer id;
/**
     * 仓库外键
     */
    private Integer storageid;
/**
     * 商品外键
     */
    private Integer commodityid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStorageid() {
        return storageid;
    }

    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

}

