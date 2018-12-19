package com.zw.vo.common;

import com.zw.dao.entity.User;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午9:34
 */
public class LoginResponseVo extends User{
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
