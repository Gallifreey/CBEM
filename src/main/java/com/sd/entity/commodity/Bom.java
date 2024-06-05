package com.sd.entity.commodity;

import java.io.Serializable;

public class Bom implements Serializable {
    private String bomName;
    private double assemblePrice;
    private double splitPrice;
    private String costFomula;

    public String getBomName() {
        return bomName;
    }

    public void setBomName(String bomName) {
        this.bomName = bomName;
    }

    public double getAssemblePrice() {
        return assemblePrice;
    }

    public void setAssemblePrice(double assemblePrice) {
        this.assemblePrice = assemblePrice;
    }

    public double getSplitPrice() {
        return splitPrice;
    }

    public void setSplitPrice(double splitPrice) {
        this.splitPrice = splitPrice;
    }

    public String getCostFomula() {
        return costFomula;
    }

    public void setCostFomula(String costFomula) {
        this.costFomula = costFomula;
    }
}
