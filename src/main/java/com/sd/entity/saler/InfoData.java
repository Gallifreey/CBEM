package com.sd.entity.saler;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class InfoData {
    private String title;
    private int value;
    private String unit;
    private double increase;
}
