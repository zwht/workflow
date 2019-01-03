package com.zw.common.vo;

/**
 * Created by zhaowei on 2017/8/17.
 */
public class PageVo<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Long pageCount;
    private T data;

    public PageVo(){

    }
    public PageVo(Integer pageNum, Integer pageSize, Long pageCount, T data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.data = data;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Long getPageCount() {
        return this.pageCount;
    }

    public T getData() {
        return this.data;
    }
}
