package com.sd.entity;

import com.sd.entity.commodity.*;

import java.io.Serial;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

/**
 * (Commodity)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:00:24
 */
public class Commodity implements Serializable {
    @Serial
    private static final long serialVersionUID = -32185165628429318L;
/**
     * 商品主键
     */
    private Integer id;
    /**
     * 商品key
     */
    private Integer key;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    /**
     * 商品名称
     */
    private String name;
/**
     * 商品描述
     */
    private String description;
/**
     * 商品销售价格
     */
    private Double saleprice;
/**
     * 商品分发价格
     */
    private Double distributionprice;
/**
     * 商品所属品牌
     */
    private Integer brand;
/**
     * 快递方式
     */
    private Integer deliverystate;
/**
     * 商品单位
     */
    private Integer unit;
/**
     * 商品重量
     */
    private Double weight;
/**
     * 商品BOM名称
     */
    private String bomname;
/**
     * 根BOM编号集
     */
    private String parentbomid;
/**
     * 子BOM编号集
     */
    private String childrenbomid;
/**
     * 组装费用
     */
    private Double assembleprice;
/**
     * 拆分费用
     */
    private Double splitprice;
/**
     * BOM成本计算方式
     */
    private String costfomula;
/**
     * 商品颜色
     */
    private String color;
/**
     * 商品尺寸
     */
    private String size;
/**
     * SKU颜色
     */
    private String skucolor;
/**
     * SKU尺寸
     */
    private Double skusize;
/**
     * SKU条形码信息
     */
    private String skubarcodemsg;
/**
     * SKU关联商品编码集
     */
    private String skuassociatedid;
/**
     * SKU重量
     */
    private Double skuweight;
/**
     * 商品状态
     */
    private Integer status;
/**
     * 商品余量
     */
    private Integer remaining;
/**
     * 商品条形码信息
     */
    private String barcodemsg;
/**
     * 商品图
     */
    private String picture;
/**
     * 商品发布时间
     */
    private Date publishtime;

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) throws ParseException {
        this.publishTime = publishTime;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.publishtime = ft.parse(publishTime);
    }

    /**
     * 商品发布时间String
     */
    private String publishTime;
/**
     * 商品上架时间
     */
    private Date onsaletime;


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

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public Double getDistributionprice() {
        return distributionprice;
    }

    public void setDistributionprice(Double distributionprice) {
        this.distributionprice = distributionprice;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getDeliverystate() {
        return deliverystate;
    }

    public void setDeliverystate(Integer deliverystate) {
        this.deliverystate = deliverystate;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBomname() {
        return bomname;
    }

    public void setBomname(String bomname) {
        this.bomname = bomname;
    }

    public String getParentbomid() {
        return parentbomid;
    }

    public void setParentbomid(String parentbomid) {
        this.parentbomid = parentbomid;
    }

    public String getChildrenbomid() {
        return childrenbomid;
    }

    public void setChildrenbomid(String childrenbomid) {
        this.childrenbomid = childrenbomid;
    }

    public Double getAssembleprice() {
        return assembleprice;
    }

    public void setAssembleprice(Double assembleprice) {
        this.assembleprice = assembleprice;
    }

    public Double getSplitprice() {
        return splitprice;
    }

    public void setSplitprice(Double splitprice) {
        this.splitprice = splitprice;
    }

    public String getCostfomula() {
        return costfomula;
    }

    public void setCostfomula(String costfomula) {
        this.costfomula = costfomula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSkucolor() {
        return skucolor;
    }

    public void setSkucolor(String skucolor) {
        this.skucolor = skucolor;
    }

    public Double getSkusize() {
        return skusize;
    }

    public void setSkusize(Double skusize) {
        this.skusize = skusize;
    }

    public String getSkubarcodemsg() {
        return skubarcodemsg;
    }

    public void setSkubarcodemsg(String skubarcodemsg) {
        this.skubarcodemsg = skubarcodemsg;
    }

    public String getSkuassociatedid() {
        return skuassociatedid;
    }

    public void setSkuassociatedid(String skuassociatedid) {
        this.skuassociatedid = skuassociatedid;
    }

    public Double getSkuweight() {
        return skuweight;
    }

    public void setSkuweight(Double skuweight) {
        this.skuweight = skuweight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public String getBarcodemsg() {
        return barcodemsg;
    }

    public void setBarcodemsg(String barcodemsg) {
        this.barcodemsg = barcodemsg;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Date getOnsaletime() {
        return onsaletime;
    }

    public void setOnsaletime(Date onsaletime) {
        this.onsaletime = onsaletime;
    }



    public void setDetails(Details details){
        BasicInfo basicInfo = details.getBasicInfo();
        Bom bom = details.getBom();
        Sku sku = details.getSku();
        Meta meta = details.getMeta();
        this.id = details.getId();
        this.name = basicInfo.getName();
        this.description = basicInfo.getDescription();
        this.saleprice = basicInfo.getSalePrice();
        this.distributionprice = basicInfo.getDistributionPrice();
        this.brand = basicInfo.getBrand();
        this.deliverystate = basicInfo.getDeliveryState();
        this.unit = basicInfo.getUnit();
        this.weight = basicInfo.getWeight();
        this.bomname = bom.getBomName();
        this.assembleprice = bom.getAssemblePrice();
        this.splitprice = bom.getSplitPrice();
        this.costfomula = bom.getCostFomula();
        this.barcodemsg = meta.getBarCodeMsg();
        this.picture = meta.getPicture();
        this.skucolor = sku.getSkuColor();
        this.skubarcodemsg = sku.getSkuBarCodeMsg();
        this.skuassociatedid = sku.getSkuAssociatedID();
        this.skuweight = sku.getSkuWeight();
    }
}

