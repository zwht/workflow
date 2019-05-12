package com.zw.service.product;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Product;
import com.zw.dao.entity.ProductExample;
import com.zw.dao.mapper.generate.ProductMapper;
import com.zw.vo.product.ProductAddVo;
import com.zw.vo.product.ProductSearchVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:04
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseVo add(ProductAddVo[] productList, TokenVo tokenVo) {
        ResponseVo response = new ResponseVo();
        try {
            // 修改成功，然后删除所有，在添加
            ProductExample productExample = new ProductExample();
            ProductExample.Criteria criteria2 = productExample.createCriteria();
            criteria2.andTicketIdEqualTo(productList[0].getTicketId());
            productMapper.deleteByExample(productExample);
            for(int i=0;i<productList.length;i++){
                Product product = new Product();
                BeanUtils.copyProperties(productList[i], product);
                product.setCorporationId(Long.parseLong(tokenVo.getCorporationId()));

                product.setId(new SnowFlake(1, 1).nextId());
                // product.setState(1501);
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
                if (constraintViolations.size() != 0) {
                    // return response.validation(constraintViolations);
                } else {
                    productMapper.insert(product);
                    // return response.success("添加成功");
                }
            }
            return response.success("添加成功");

        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getById(Long id) {
        ResponseVo<Product> response = new ResponseVo();
        try {
            return response.success(productMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Product product) {
        ResponseVo response = new ResponseVo();
        try {
            ProductExample productExample = new ProductExample();
            ProductExample.Criteria criteria = productExample.createCriteria();
            criteria.andCorporationIdEqualTo(product.getCorporationId());
            criteria.andIdNotEqualTo(product.getId());
            // 查询是否有相同
            List<Product> corporations = productMapper.selectByExample(productExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ProductExample example = new ProductExample();
                    ProductExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(product.getId());
                    productMapper.updateByExampleSelective(product, example);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "数据重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getList(Integer pageNum, Integer pageSize, ProductSearchVo productSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        ProductExample example = new ProductExample();
        example.setOrderByClause("`sum` DESC");
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(productSearchVo.getTicketId())) {
            criteria.andTicketIdEqualTo(productSearchVo.getTicketId());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = productMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        Product product = productMapper.selectByPrimaryKey(id);
        product.setFlag((short)1);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(product.getId());
        productMapper.updateByExampleSelective(product, example);
        return response.success("删除成功");
    }
    @Override
    public ResponseVo updateState(Long id, Short state) {
        ResponseVo response = new ResponseVo();
        Product product = productMapper.selectByPrimaryKey(id);
        product.setState(Integer.valueOf(state));
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);

            if (constraintViolations.size() != 0) {
                return response.validation(constraintViolations);
            } else {
                ProductExample example = new ProductExample();
                ProductExample.Criteria criteria1 = example.createCriteria();
                criteria1.andIdEqualTo(product.getId());
                productMapper.updateByExampleSelective(product, example);
                return response.success("修改成功");
            }
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}