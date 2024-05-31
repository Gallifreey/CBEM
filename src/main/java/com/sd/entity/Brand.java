package com.sd.entity;

import java.io.Serializable;

/**
 * (Brand)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:02:52
 */
public class Brand implements Serializable {
    private static final long serialVersionUID = 677178396433434978L;
/**
     * 品牌主键
     */
    private Integer id;
/**
     * 品牌名称
     */
    private String name;
/**
     * 品牌描述
     */
    private String description;


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

}

