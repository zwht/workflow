package com.zw.common.vo;


/**
 *  @author         jamie  
 *  @version        V1.0   
 *  @date           2018/3/12 14:19  
 */
public class ResultVo<T> {

    private Integer errorCode=0;

    private T data = null;

    private String msg;

    public ResultVo() {
    }

    public ResultVo(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ResultVo(Integer errorCode, T t) {
        this.errorCode = errorCode;
        this.data = t;
    }
    public ResultVo(T t) {
        this.data = t;
    }
    public ResultVo(Integer errorCode, T t, String msg) {
        this.errorCode = errorCode;
        this.data = t;
        this.msg = msg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
