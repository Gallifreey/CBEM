package com.sd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.net.ntp.TimeStamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Storage)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Storage implements Serializable {
    private static final long serialVersionUID = -96128386955532766L;
/**
     * 仓库主键
     */
    private Integer id;
/**
     * 仓库名称
     */
    private String name;
/**
     * 仓库描述
     */
    private String description;
/**
     * 仓库地址
     */
    private String address;
/**
     * 仓库类型
     */
    private Integer type;
/**
     * 仓库递送方式
     */
    private Integer deliverystate;
    /**
     * 库存
     */
    private Integer remained;
    /**
     * 授权
     */
    private Integer auth;
    private String picture;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime authTime;

    public LocalDateTime getAuthTime() {
        return authTime;
    }

    public void setAuthTime(LocalDateTime authTime) {
        this.authTime = authTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public Integer getRemained() {
        return remained;
    }

    public void setRemained(Integer remained) {
        this.remained = remained;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDeliverystate() {
        return deliverystate;
    }

    public void setDeliverystate(Integer deliverystate) {
        this.deliverystate = deliverystate;
    }

}

