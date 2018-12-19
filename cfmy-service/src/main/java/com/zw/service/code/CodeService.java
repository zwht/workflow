package com.zw.service.code;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Code;
import com.zw.vo.code.CodeSearchVo;
import com.zw.vo.code.CodeAddVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface CodeService {
    ResponseVo add(CodeAddVo codeAddVo);
    ResponseVo getById(Long id);
    ResponseVo update(Code code);
    ResponseVo getList(Integer pageNum, Integer pageSize, CodeSearchVo codeSearchVo);
    ResponseVo del(Long id);
}
