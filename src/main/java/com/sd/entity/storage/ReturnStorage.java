package com.sd.entity.storage;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReturnStorage implements Serializable {
    private int key;
    private String name;
    private String address;
    private String authTime;
    private String picture;
}
