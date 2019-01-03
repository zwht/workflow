package com.zw.vo.corporation;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:00
 */
public class CorporationSearchVo {

    @ApiModelProperty("公司名")
    public String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
