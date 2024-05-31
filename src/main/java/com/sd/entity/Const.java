package com.sd.entity;

import java.io.Serializable;

/**
 * (Const)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Const implements Serializable {
    private static final long serialVersionUID = 463843002159703087L;
/**
     * 常量主键
     */
    private Integer id;
/**
     * 常量名
     */
    private String name;
/**
     * 常量类型外键
     */
    private Integer type;


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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}

