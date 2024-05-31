package com.sd.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class Token implements Serializable {
    String token;
    int role;
    String avatar;
    String password;
}
