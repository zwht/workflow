package com.zw.vo.brand;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class BrandAddVo {
    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("描述")
    private String describeWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribeWord() {
        return describeWord;
    }

    public void setDescribeWord(String describeWord) {
        this.describeWord = describeWord;
    }
}
