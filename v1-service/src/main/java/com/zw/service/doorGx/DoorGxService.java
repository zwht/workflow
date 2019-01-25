package com.zw.service.doorGx;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.DoorGx;
import com.zw.vo.doorGx.DoorGxAddVo;
import com.zw.vo.doorGx.DoorGxSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface DoorGxService {
    ResponseVo add(DoorGxAddVo doorGxAddVo, String corporationId);
    ResponseVo getById(Long id);
    ResponseVo update(DoorGx doorGx);
    ResponseVo getList(Integer pageNum, Integer pageSize, DoorGxSearchVo doorGxSearchVo);
    ResponseVo del(Long id);
}
