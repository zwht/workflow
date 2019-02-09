package com.zw.vo.color;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:00
 */
public class ColorSearchVo {


    @ApiModelProperty("颜色名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
