package com.zw.vo.gx;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class GxAddVo {
    @ApiModelProperty("工序名")
    private String name;

    @ApiModelProperty("默认价格")
    private Long price;

    @ApiModelProperty("排序")
    private Short indexKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Short getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(Short indexKey) {
        this.indexKey = indexKey;
    }
}
