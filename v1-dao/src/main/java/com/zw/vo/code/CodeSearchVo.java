package com.zw.vo.code;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:00
 */
public class CodeSearchVo {
    @ApiModelProperty("码名")
    private String name;

    @ApiModelProperty("码组ID")
    private Long groupId;

    @ApiModelProperty("值开始")
    private Short valueStart;

    @ApiModelProperty("值开结束")
    private Short valueEnd;

    public Short getValueStart() {
        return valueStart;
    }

    public void setValueStart(Short valueStart) {
        this.valueStart = valueStart;
    }

    public Short getValueEnd() {
        return valueEnd;
    }

    public void setValueEnd(Short valueEnd) {
        this.valueEnd = valueEnd;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
