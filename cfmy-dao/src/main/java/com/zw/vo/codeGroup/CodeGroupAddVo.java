package com.zw.vo.codeGroup;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class CodeGroupAddVo {
    @ApiModelProperty("码组名")
    private String name;

    @ApiModelProperty("码组值")
    private Short value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }
}
