package com.sd.entity.commodity;

import java.io.Serializable;

public class Sku implements Serializable {
    private String skuColor;
    private String skuBarCodeMsg;
    private Integer skuAssociatedID;
    private double skuWeight;

    public String getSkuColor() {
        return skuColor;
    }

    public void setSkuColor(String skuColor) {
        this.skuColor = skuColor;
    }

    public String getSkuBarCodeMsg() {
        return skuBarCodeMsg;
    }

    public void setSkuBarCodeMsg(String skuBarCodeMsg) {
        this.skuBarCodeMsg = skuBarCodeMsg;
    }

    public Integer getSkuAssociatedID() {
        return skuAssociatedID;
    }

    public void setSkuAssociatedID(Integer skuAssociatedID) {
        this.skuAssociatedID = skuAssociatedID;
    }

    public double getSkuWeight() {
        return skuWeight;
    }

    public void setSkuWeight(double skuWeight) {
        this.skuWeight = skuWeight;
    }
}
