package com.zw.service.codeGroup;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.CodeGroup;
import com.zw.vo.codeGroup.CodeGroupAddVo;
import com.zw.vo.codeGroup.CodeGroupSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface CodeGroupService {
    ResponseVo add(CodeGroupAddVo codeGroupAddVo);
    ResponseVo getById(Long id);
    ResponseVo update(CodeGroup codeGroup);
    ResponseVo getList(Integer pageNum, Integer pageSize, CodeGroupSearchVo codeGroupSearchVo);
    ResponseVo del(Long id);
}
