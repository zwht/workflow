package com.zw.vo.process;

import com.zw.dao.entity.Corporation;
import com.zw.vo.code.CodeResponseVo;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/22
 * @Time：下午2:14
 */
public class ProcessResponseVo {
    private Long id;

    private Long gxId;

    private Long userId;

    private Long corporationId;

    private BigDecimal price;

    private BigDecimal priceAdd;

    private Short indexKey;

    private Integer type;

    private Date startTime;

    private Date endTime;

    private Date updateTime;

    private Integer state;

    private Long productId;

    private Long ticketId;

    private Short flag;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGxId() {
        return gxId;
    }

    public void setGxId(Long gxId) {
        this.gxId = gxId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
        this.corporationId = corporationId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceAdd() {
        return priceAdd;
    }

    public void setPriceAdd(BigDecimal priceAdd) {
        this.priceAdd = priceAdd;
    }

    public Short getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(Short indexKey) {
        this.indexKey = indexKey;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
