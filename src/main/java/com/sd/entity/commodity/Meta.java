package com.sd.entity.commodity;

import com.sd.entity.Commodity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class Meta implements Serializable {
    private String barCodeMsg;
    private String picture;
    public Meta(Commodity commodity) {
        this.barCodeMsg = commodity.getBarcodemsg();
        this.picture = commodity.getPicture();
    }

}
