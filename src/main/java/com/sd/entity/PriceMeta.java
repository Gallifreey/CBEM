package com.sd.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class PriceMeta implements Serializable {
    String name;
    String code;
    String unit;
    double price;
    int total;
}
