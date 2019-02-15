package com.zw.service.product;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Product;
import com.zw.vo.product.ProductAddVo;
import com.zw.vo.product.ProductSearchVo;

import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface ProductService {
    ResponseVo add(ProductAddVo[] productAddVo, TokenVo tokenVo);
    ResponseVo getById(Long id);
    ResponseVo update(Product product);
    ResponseVo getList(Integer pageNum, Integer pageSize, ProductSearchVo productSearchVo);
    ResponseVo del(Long id);
    ResponseVo updateState(Long id, Short state);
}
