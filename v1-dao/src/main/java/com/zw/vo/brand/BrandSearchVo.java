package com.zw.vo.brand;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:00
 */
public class BrandSearchVo {
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("公司")
    private Long corporationId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
        this.corporationId = corporationId;
    }
}
