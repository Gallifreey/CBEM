package com.sd.entity.commodity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Query {
    private String name;
    private double price;
    private String brand;
    private int remained;
    private Date publishTime;
}
