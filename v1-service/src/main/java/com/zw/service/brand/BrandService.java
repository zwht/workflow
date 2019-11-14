package com.zw.service.brand;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Brand;
import com.zw.vo.brand.BrandAddVo;
import com.zw.vo.brand.BrandSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface BrandService {
    ResponseVo add(BrandAddVo brandAddVo, TokenVo tokenVo);
    ResponseVo getById(Long id);
    ResponseVo update(Brand brand);
    ResponseVo getList(Integer pageNum, Integer pageSize, BrandSearchVo brandSearchVo, TokenVo tokenVo);
    ResponseVo del(Long id);
}
