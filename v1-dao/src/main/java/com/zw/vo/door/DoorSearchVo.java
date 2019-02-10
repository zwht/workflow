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

    @ApiModelProperty("编号")
    private String number;

    @ApiModelProperty("类型")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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
