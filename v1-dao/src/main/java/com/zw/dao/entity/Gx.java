package com.zw.dao.entity;

import java.math.BigDecimal;

public class Gx {
    private Long id;

    private String name;

    private Short state;

    private Long corporationId;

    private BigDecimal price;

    private Short indexKey;

    private Short flag;

    private String relyOn;

    private Long defaultUserId;

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
        this.name = name == null ? null : name.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
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

    public Short getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(Short indexKey) {
        this.indexKey = indexKey;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getRelyOn() {
        return relyOn;
    }

    public void setRelyOn(String relyOn) {
        this.relyOn = relyOn == null ? null : relyOn.trim();
    }

    public Long getDefaultUserId() {
        return defaultUserId;
    }

    public void setDefaultUserId(Long defaultUserId) {
        this.defaultUserId = defaultUserId;
    }
}