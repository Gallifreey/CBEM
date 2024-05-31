package com.sd.entity;

import java.io.Serializable;

/**
 * (Storagemanager)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Storagemanager implements Serializable {
    private static final long serialVersionUID = -74876042271461603L;
/**
     * 仓库管理人主键
     */
    private Integer id;
/**
     * 用户主键
     */
    private Integer uid;
/**
     * 仓库主键
     */
    private Integer storgeid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStorgeid() {
        return storgeid;
    }

    public void setStorgeid(Integer storgeid) {
        this.storgeid = storgeid;
    }

}

