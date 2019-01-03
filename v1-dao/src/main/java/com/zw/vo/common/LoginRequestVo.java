package com.zw.vo.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午9:34
 */
public class LoginRequestVo {

    @ApiModelProperty(value="登录名", example = "zw")
    public String loginName;

    @ApiModelProperty(value="密码", example = "MTIzNDU2")
    public String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
