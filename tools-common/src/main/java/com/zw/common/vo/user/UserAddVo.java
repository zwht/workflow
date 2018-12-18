package com.zw.common.vo.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/18
 * @Time：上午11:54
 */
public class UserAddVo {

    @ApiModelProperty(value="用户名")
    private String name;

    @ApiModelProperty(value="登录名")
    private String loginName;

    @ApiModelProperty(value="能力，权限")
    private String ability;

    @ApiModelProperty(value="角色")
    private String roles;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="公司名")
    private String corporationId;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="头像")
    private String avatar;

    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="地址Id")
    private String addressId;

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

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
