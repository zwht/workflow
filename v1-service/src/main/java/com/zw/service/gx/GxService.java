package com.zw.service.gx;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Gx;
import com.zw.vo.gx.GxAddVo;
import com.zw.vo.gx.GxSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface GxService {
    ResponseVo add(GxAddVo gxAddVo, String corporationId);
    ResponseVo getById(Long id);
    ResponseVo update(Gx gx);
    ResponseVo getList(Integer pageNum, Integer pageSize, GxSearchVo gxSearchVo);
    ResponseVo del(Long id);
    ResponseVo updateState(Long id, Short state);
}
