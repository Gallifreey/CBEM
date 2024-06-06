package com.sd.entity.commodity;

import com.sd.entity.Commodity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class Bom implements Serializable {
    private String bomName;
    private double assemblePrice;
    private double splitPrice;
    private String costFomula;
    public Bom(Commodity commodity) {
        this.bomName = commodity.getBomname();
        this.assemblePrice = commodity.getAssembleprice();
        this.splitPrice = commodity.getSplitprice();
        this.costFomula = commodity.getCostfomula();
    }

}
