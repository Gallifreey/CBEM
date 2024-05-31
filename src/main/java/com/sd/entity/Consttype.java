package com.sd.entity;

import java.io.Serializable;

/**
 * (Consttype)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Consttype implements Serializable {
    private static final long serialVersionUID = 133120216208052596L;
/**
     * 常量类型主键
     */
    private Integer id;
/**
     * 常量类型名
     */
    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}

