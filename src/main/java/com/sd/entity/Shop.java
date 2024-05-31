package com.sd.entity;

import java.io.Serializable;

/**
 * (Shop)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = -16493881875314412L;
/**
     * 商店/门店主键
     */
    private Integer id;
/**
     * 门店名称
     */
    private String name;
/**
     * 门店描述
     */
    private String description;
/**
     * 门店地址
     */
    private String address;
/**
     * 门店图片
     */
    private String picture;
/**
     * 门店所有人外键
     */
    private Integer owner;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

}

