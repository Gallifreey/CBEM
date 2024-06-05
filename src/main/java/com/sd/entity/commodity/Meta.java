package com.sd.entity.commodity;

import java.io.Serializable;

public class Meta implements Serializable {
    private String barCodeMsg;
    private String picture;

    public String getBarCodeMsg() {
        return barCodeMsg;
    }

    public void setBarCodeMsg(String barCodeMsg) {
        this.barCodeMsg = barCodeMsg;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
