package com.zw.vo.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/18
 * @Time：上午11:54
 */
public class UserAddVo {

    @ApiModelProperty("用户名1")
    private String name;

    @ApiModelProperty("登录名")
    private String loginName;

    @ApiModelProperty("能力，权限")
    private String ability;

    @ApiModelProperty("角色")
    private String roles;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("公司名")
    private Long corporationId;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("工序ids")
    private String gxIds;

    @ApiModelProperty("邀请人id")
    private Long inviteId;

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("默认发货地址")
    private String address;

    @ApiModelProperty("默认快递")
    private String courier;

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

    public Long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Long corporationId) {
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

    public String getGxIds() {
        return gxIds;
    }

    public void setGxIds(String gxIds) {
        this.gxIds = gxIds;
    }

    public Long getInviteId() {
        return inviteId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }
}
