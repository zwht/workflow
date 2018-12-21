package com.zw.dao.mapper.my;

import com.zw.dao.entity.Code;
import com.zw.dao.entity.CodeExample;

import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/21
 * @Time：下午5:21
 */
public interface MyCodeMapper {
    List<Code> selectByExample(CodeExample example);
}
