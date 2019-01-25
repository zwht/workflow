package com.zw.common.vo;

import javax.validation.ConstraintViolation;
import java.util.*;

/**
 * Created by zhaowei on 2017/6/29.
 */
public class ResponseVo<D> {
    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Integer status = 200;
    private D response;
    private String msg;
    private List<Map<String, String>> msgObj;

    public ResponseVo(){
    }
    public ResponseVo(D response){
        this.setResponse(response);
    }
    public ResponseVo(Integer status, D response){
        this.setResponse(response);
        this.setStatus(status);
    }

    public ResponseVo success() {
        this.setMsg(OK);
        return this;
    }

    public ResponseVo success(D response) {
        this.setMsg(OK);
        this.setResponse(response);
        return this;
    }

    public ResponseVo failure(Integer status) {
        this.setMsg(ERROR);
        this.setStatus(status);
        return this;
    }

    public ResponseVo failure(Integer status, String msg) {
        this.setMsg(msg);
        this.setStatus(status);
        return this;
    }

    public ResponseVo failure(Integer status, List msgObj) {
        this.setMsg("验证错误");
        this.setMsgObj(msgObj);
        this.setStatus(status);
        return this;
    }

    public ResponseVo validation(Set<ConstraintViolation> constraintViolations) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            Map<String, String> violatorList = new HashMap<String, String>();
            violatorList.put("key", constraintViolation.getPropertyPath().toString());
            violatorList.put("msg", constraintViolation.getMessage());
            violatorList.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
            list.add(violatorList);
        }
        return this.failure(400, list);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public D getResponse() {
        return response;
    }

    public void setResponse(D response) {
        this.response = response;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Map<String, String>> getMsgObj() {
        return msgObj;
    }

    public void setMsgObj(List<Map<String, String>> msgObj) {
        this.msgObj = msgObj;
    }
}
