package com.zw.service.door;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Door;
import com.zw.vo.door.DoorAddVo;
import com.zw.vo.door.DoorSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface DoorService {
    ResponseVo add(DoorAddVo doorAddVo, TokenVo tokenVo);
    ResponseVo getById(Long id);
    ResponseVo update(Door door);
    ResponseVo getList(Integer pageNum, Integer pageSize, DoorSearchVo doorSearchVo);
    ResponseVo del(Long id);
    ResponseVo updateState(Long id, Short state);
}
