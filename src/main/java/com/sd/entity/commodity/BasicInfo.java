package com.sd.entity.commodity;

import com.sd.entity.Commodity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class BasicInfo implements Serializable {
    public BasicInfo(Commodity commodity) {
        this.name = commodity.getName();
        this.description = commodity.getDescription();
        this.salePrice = commodity.getSaleprice();
        this.distributionPrice = commodity.getDistributionprice();
        this.brand =commodity.getBrand();
        this.deliveryState = commodity.getDeliverystate();
        this.unit = commodity.getUnit();
        this.weight = commodity.getWeight();
    }

    private String name;
    private String description;
    private double salePrice;
    private double distributionPrice;
    private Integer brand;
    private Integer deliveryState;
    private Integer unit;
    private Double weight;
}

