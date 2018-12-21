package com.zw.dao.mapper.my;

import com.zw.dao.entity.Code;
import com.zw.dao.entity.CodeExample;

import java.util.List;

/**
 * MyCodeMapper接口，处理code关联查询
 * @author：zhaowei
 */
public interface MyCodeMapper {
    /**
     * 关联查询code列表
     *  @param example 查询对象
     *  @return Code
     */
    List<Code> selectByExample(CodeExample example);
}
