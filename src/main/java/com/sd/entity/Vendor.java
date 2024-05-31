package com.sd.entity;

import java.io.Serializable;

/**
 * (Vendor)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
public class Vendor implements Serializable {
    private static final long serialVersionUID = 368820973951571349L;
/**
     * 供货商主键
     */
    private Integer id;
/**
     * 供货商名称
     */
    private String name;
/**
     * 供货商描述
     */
    private String description;
/**
     * 供货商地址
     */
    private String address;
/**
     * 供货商电话
     */
    private String phone;
/**
     * 传真
     */
    private String fox;
/**
     * 邮件
     */
    private String email;
/**
     * 邮政编号
     */
    private String postcode;
/**
     * 网站
     */
    private String website;
/**
     * 联系人集
     */
    private String connector;
/**
     * 备注
     */
    private String remark;
/**
     * 开户行名称
     */
    private Integer accountbank;
/**
     * 开户行卡号
     */
    private String accountnumber;
/**
     * 开户行账号所有人
     */
    private String accountowner;
/**
     * 授权仓库集
     */
    private String authorizedstorage;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFox() {
        return fox;
    }

    public void setFox(String fox) {
        this.fox = fox;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAccountbank() {
        return accountbank;
    }

    public void setAccountbank(Integer accountbank) {
        this.accountbank = accountbank;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccountowner() {
        return accountowner;
    }

    public void setAccountowner(String accountowner) {
        this.accountowner = accountowner;
    }

    public String getAuthorizedstorage() {
        return authorizedstorage;
    }

    public void setAuthorizedstorage(String authorizedstorage) {
        this.authorizedstorage = authorizedstorage;
    }

}

