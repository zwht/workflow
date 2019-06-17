package com.zw.vo.door;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class DoorAddVo {
    @ApiModelProperty("产品名")
    private String name;

    @ApiModelProperty("状态")
    private Short state;

    @ApiModelProperty("产品工序id数组")
    private String gxIds;

    @ApiModelProperty("产品工序价格数组")
    private String gxValues;

    @ApiModelProperty("产品图片")
    private String img;

    @ApiModelProperty("产品类型，1301门，1302窗户")
    private Short type;

    @ApiModelProperty("产品产品编号")
    private String number;

    @ApiModelProperty("算法")
    private String arithmetic;


    @ApiModelProperty("参数")
    private String gxParams;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("单价")
    private String unitPrice;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getGxParams() {
        return gxParams;
    }

    public void setGxParams(String gxParams) {
        this.gxParams = gxParams;
    }

    public String getArithmetic() {
        return arithmetic;
    }

    public void setArithmetic(String arithmetic) {
        this.arithmetic = arithmetic;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getGxIds() {
        return gxIds;
    }

    public void setGxIds(String gxIds) {
        this.gxIds = gxIds;
    }

    public String getGxValues() {
        return gxValues;
    }

    public void setGxValues(String gxValues) {
        this.gxValues = gxValues;
    }
}
