package com.sd.entity.commodity;

import com.sd.entity.Commodity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class Sku implements Serializable {
    private String skuColor;
    private String skuBarCodeMsg;
    private String  skuAssociatedID;
    private Double skuWeight;
    public Sku(Commodity commodity) {
        this.skuColor = commodity.getSkucolor();
        this.skuBarCodeMsg = commodity.getSkubarcodemsg();
        this.skuAssociatedID = commodity.getSkuassociatedid();
        this.skuWeight = commodity.getSkuweight();
    }
}
