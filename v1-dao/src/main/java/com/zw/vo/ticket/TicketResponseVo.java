package com.zw.vo.ticket;

import java.util.Date;

/**
 * @author：zhaowei
 * @Date：2019/2/15
 * @Time：下午12:55
 */
public class TicketResponseVo {
    private Long id;

    private String name;

    private String number;

    private Long corporationId;

    private Long dealersId;

    private Long marketId;

    private Long editId;

    private Long brandId;

    private String productIds;

    private String odd;

    private String address;

    private Short state;

    private Short type;

    private Short priority;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date overTime;

    private Float pay;

    private Float sumDoor;

    private Float sumTaoban;

    private Float sumLine;

    private Short flag;

    private String summary;

    private String remarks;

    private String marketName;

    private String editName;

    private String dealersName;


    public String getEditName() {
        return editName;
    }

    public void setEditName(String editName) {
        this.editName = editName;
    }

    public String getDealersName() {
        return dealersName;
    }

    public void setDealersName(String dealersName) {
        this.dealersName = dealersName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
        this.corporationId = corporationId;
    }

    public Long getDealersId() {
        return dealersId;
    }

    public void setDealersId(Long dealersId) {
        this.dealersId = dealersId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getEditId() {
        return editId;
    }

    public void setEditId(Long editId) {
        this.editId = editId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public Float getSumDoor() {
        return sumDoor;
    }

    public void setSumDoor(Float sumDoor) {
        this.sumDoor = sumDoor;
    }

    public Float getSumTaoban() {
        return sumTaoban;
    }

    public void setSumTaoban(Float sumTaoban) {
        this.sumTaoban = sumTaoban;
    }

    public Float getSumLine() {
        return sumLine;
    }

    public void setSumLine(Float sumLine) {
        this.sumLine = sumLine;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
