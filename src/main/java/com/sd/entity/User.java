package com.sd.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class User implements Serializable {
    private static final long serialVersionUID = -22947620236328036L;
/**
     * 用户主键
     */
    private Integer id;
/**
     * 用户名
     */
    private String username;
/**
     * 密码
     */
    private String password;
/**
     * 角色
     */
    private Integer role;
/**
     * 联系方式
     */
    private String phone;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

