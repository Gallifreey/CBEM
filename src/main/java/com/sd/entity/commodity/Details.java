package com.sd.entity.commodity;

import com.sd.entity.Commodity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class Details implements Serializable {
    int id;
    private BasicInfo basicInfo;
    private Bom bom;
    private Meta meta;
    private Sku sku;
}
