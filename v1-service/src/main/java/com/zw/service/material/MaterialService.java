package com.zw.service.material;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Material;
import com.zw.vo.material.MaterialAddVo;
import com.zw.vo.material.MaterialSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface MaterialService {
    ResponseVo add(MaterialAddVo materialAddVo, Long corporationId);
    ResponseVo getById(Long id);
    ResponseVo update(Material material);
    ResponseVo getList(Integer pageNum, Integer pageSize, MaterialSearchVo materialSearchVo);
    ResponseVo del(Long id);
}
