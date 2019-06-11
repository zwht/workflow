package com.zw.vo.statistics;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class SProcessResponseVo {

    @ApiModelProperty("价格")
    private Float price;

    @ApiModelProperty("添加价格")
    private Float priceAdd;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("完成工单数量")
    private Integer cum;

    @ApiModelProperty("日期")
    private String d;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPriceAdd() {
        return priceAdd;
    }

    public void setPriceAdd(Float priceAdd) {
        this.priceAdd = priceAdd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCum() {
        return cum;
    }

    public void setCum(Integer cum) {
        this.cum = cum;
    }
}
