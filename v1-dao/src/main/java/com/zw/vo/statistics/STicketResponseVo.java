package com.zw.vo.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class STicketResponseVo {

    @ApiModelProperty("日期")
    private String d;

    @ApiModelProperty("数量")
    private String cum;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getCum() {
        return cum;
    }

    public void setCum(String cum) {
        this.cum = cum;
    }
}
