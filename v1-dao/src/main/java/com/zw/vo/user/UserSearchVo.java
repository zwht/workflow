package com.zw.vo.user;
/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午11:07
 */
public class UserSearchVo {
    private String corporationId;
    private String roles;
    private String name;
    private String loginName;

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
