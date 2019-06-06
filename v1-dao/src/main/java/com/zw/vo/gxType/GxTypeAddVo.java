package com.zw.vo.gxType;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class GxTypeAddVo {
    @ApiModelProperty("工序id")
    private Long gxId;
    @ApiModelProperty("名字描述")
    private String name;
    @ApiModelProperty("价格")
    private Float price;
    @ApiModelProperty("排序")
    private Short indexKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGxId() {
        return gxId;
    }

    public void setGxId(Long gxId) {
        this.gxId = gxId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Short getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(Short indexKey) {
        this.indexKey = indexKey;
    }
}
