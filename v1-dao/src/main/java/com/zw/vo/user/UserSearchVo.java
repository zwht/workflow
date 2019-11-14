package com.zw.vo.user;
/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午11:07
 */
public class UserSearchVo {
    private Long corporationId;
    private String roles;
    private String name;
    private String loginName;
    private Integer invite;

    public Integer getInvite() {
        return invite;
    }

    public void Integer(Integer invite) {
        invite = invite;
    }

    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
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
