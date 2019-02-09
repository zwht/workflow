package com.zw.service.color;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Color;
import com.zw.vo.color.ColorAddVo;
import com.zw.vo.color.ColorSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface ColorService {
    ResponseVo add(ColorAddVo colorAddVo, String corporationId);
    ResponseVo getById(Long id);
    ResponseVo update(Color color);
    ResponseVo getList(Integer pageNum, Integer pageSize, ColorSearchVo colorSearchVo);
    ResponseVo del(Long id);
}
