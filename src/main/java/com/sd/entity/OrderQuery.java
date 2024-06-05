package com.sd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2024-05-22 15:01:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderQuery implements Serializable {
    private static final long serialVersionUID = 396490587558426038L;

    private Integer source;
    /**
     * 订单接收人
     */
    private Integer target;
    /**
     * 发布时间
     */
    private String publishTime;
    private Date publishtime;

    public String getPublishTime() {
        return publishTime;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}

