package com.zw.service.corporation;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Corporation;
import com.zw.vo.corporation.CorporationAddVo;
import com.zw.vo.corporation.CorporationSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface CorporationService {
    ResponseVo add(CorporationAddVo corporationAddVo);
    ResponseVo getById(Long id);
    ResponseVo update(Corporation corporation);
    ResponseVo getList(Integer pageNum, Integer pageSize, CorporationSearchVo corporationSearchVo);
    ResponseVo del(Long id);
}
