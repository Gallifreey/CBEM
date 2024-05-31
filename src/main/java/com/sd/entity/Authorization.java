package com.sd.entity;

import java.io.Serializable;

/**
 * (Authorization)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:02:52
 */
public class Authorization implements Serializable {
    private static final long serialVersionUID = 776804632003717605L;
/**
     * 用户权限主键
     */
    private Integer id;
/**
     * 权限名称
     */
    private String name;
/**
     * 权限类标识码
     */
    private String authorizationcode;
/**
     * 权限注释
     */
    private String comment;


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

    public String getAuthorizationcode() {
        return authorizationcode;
    }

    public void setAuthorizationcode(String authorizationcode) {
        this.authorizationcode = authorizationcode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

