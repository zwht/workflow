package com.zw.service.gxType;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.GxType;
import com.zw.vo.gxType.GxTypeAddVo;
import com.zw.vo.gxType.GxTypeSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface GxTypeService {
    ResponseVo add(GxTypeAddVo gxTypeAddVo, Long corporationId);
    ResponseVo getById(Long id);
    ResponseVo update(GxType gxType);
    ResponseVo getList(Integer pageNum, Integer pageSize, GxTypeSearchVo gxTypeSearchVo);
    ResponseVo del(Long id);
}
