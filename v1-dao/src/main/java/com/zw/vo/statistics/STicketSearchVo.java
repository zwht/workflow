package com.zw.vo.statistics;

import com.zw.common.util.DateKit;
import io.swagger.annotations.ApiModelProperty;

import java.text.ParseException;
import java.util.Date;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:03
 */
public class STicketSearchVo {

    @ApiModelProperty("公司id")
    private Long corporationId;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("年3，月2，日1")
    private Short type;


    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
        this.corporationId = corporationId;
    }

    public Date getStartTime() {
        try{
            return DateKit.getDate(startTime,"yyyy-MM-dd");
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        try{
            return DateKit.getDate(endTime,"yyyy-MM-dd");
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
}
