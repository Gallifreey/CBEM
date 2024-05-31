package com.sd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {
    private static final long serialVersionUID = 396490587558426038L;
/**
     * 订单主键
     */
    private Integer id;
/**
     * 订单名称
     */
    private int key;
    private String name;
/**
     * 订单描述
     */
    private String description;
/**
     * 订单发起人
     */
    private Integer source;
/**
     * 订单接收人
     */
    private Integer target;
/**
     * 发布时间
     */
    private Date publishtime;


    /**
     * 订单价格元数据
     */

    @JsonIgnore
    private String pricemeta;

    private PriceMeta meta;
/**
     * 订单信息元数据
     */
    private String infometa;
/**
     * 订单基本元数据
     */
    private String manifestmeta;
/**
     * 订单状态
     */
    private Integer state;

}

