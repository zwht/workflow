package com.zw.vo.brand;

import com.zw.dao.entity.Brand;

/**
 * @author：zhaowei
 * @Date：2018/12/21
 * @Time：下午6:00
 */
public class BrandResponseVo extends Brand {

    private String name;
    private String describeWord;

    @Override
    public String getName() {
        return name;
    }

    @Override
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
