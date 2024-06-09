package com.sd.entity.storage;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class QueryStorage implements Serializable {
    private String name;
    private String []authTime;
    private String belowTime;
    private String topTime;
    private String address;
}
