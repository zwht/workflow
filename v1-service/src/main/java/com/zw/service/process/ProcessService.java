package com.zw.service.process;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Process;
import com.zw.vo.process.ProcessAddVo;
import com.zw.vo.process.ProcessSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface ProcessService {
    ResponseVo add(ProcessAddVo[] processAddVo, TokenVo tokenVo);
    ResponseVo getById(Long id);
    ResponseVo update(Process process);
    ResponseVo getList(Integer pageNum, Integer pageSize, ProcessSearchVo processSearchVo);
    ResponseVo del(Long id);
    ResponseVo updateState(Long id, Short state);
}
