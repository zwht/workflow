package com.zw.dao.entity;

public class Brand {
    private Long id;

    private String name;

    private Long corporationId;

    private String describeWord;

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

    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
        this.corporationId = corporationId;
    }

    public String getDescribeWord() {
        return describeWord;
    }

    public void setDescribeWord(String describeWord) {
        this.describeWord = describeWord == null ? null : describeWord.trim();
    }
}