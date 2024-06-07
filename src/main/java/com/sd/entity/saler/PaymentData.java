package com.sd.entity.saler;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaymentData {
    private String date;
    private double price;
    private String type;
}
