package com.zw.vo.doorGx;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class DoorGxAddVo {
    @ApiModelProperty("工序id")
    private Long gxId;
    @ApiModelProperty("门id")
    private Long doorId;
    @ApiModelProperty("价格")
    private Float price;
    @ApiModelProperty("排序")
    private Short indexKey;

    public Long getGxId() {
        return gxId;
    }

    public void setGxId(Long gxId) {
        this.gxId = gxId;
    }

    public Long getDoorId() {
        return doorId;
    }

    public void setDoorId(Long doorId) {
        this.doorId = doorId;
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
