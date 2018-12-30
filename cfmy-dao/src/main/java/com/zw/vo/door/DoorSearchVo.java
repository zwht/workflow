package com.zw.vo.door;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:00
 */
public class DoorSearchVo {

    @ApiModelProperty("工序名")
    public String name;

    @ApiModelProperty("公司id")
    private Long corporationId;

    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
        this.corporationId = corporationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
