package com.zw.service.brand;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Brand;
import com.zw.dao.entity.BrandExample;
import com.zw.dao.mapper.generate.BrandMapper;
import com.zw.vo.brand.BrandAddVo;
import com.zw.vo.brand.BrandSearchVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:04
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;


    @Override
    public ResponseVo add(BrandAddVo brandAddVo, TokenVo tokenVo) {
        ResponseVo response = new ResponseVo();
        try {
            Brand brand = new Brand();
            BeanUtils.copyProperties(brandAddVo, brand);
            brand.setCorporationId(tokenVo.getCorporationId());

            BrandExample brandExample = new BrandExample();
            BrandExample.Criteria criteria = brandExample.createCriteria();
            criteria.andNameEqualTo(brand.getName());
            criteria.andCorporationIdEqualTo(brand.getCorporationId());
            // 查询是否有相同
            List<Brand> brands = brandMapper.selectByExample(brandExample);
            if (brands.size() == 0) {
                brand.setId(new SnowFlake(1, 1).nextId());
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Brand>> constraintViolations = validator.validate(brand);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    brandMapper.insert(brand);
                    return response.success("添加成功");
                }
            } else {
                return response.failure(400, "数据重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getById(Long id) {
        ResponseVo<Brand> response = new ResponseVo();
        try {
            return response.success(brandMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Brand brand) {
        ResponseVo response = new ResponseVo();
        try {
            BrandExample brandExample = new BrandExample();
            BrandExample.Criteria criteria = brandExample.createCriteria();
            criteria.andNameEqualTo(brand.getName());
            criteria.andIdNotEqualTo(brand.getId());
            // 查询是否有相同
            List<Brand> corporations = brandMapper.selectByExample(brandExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Brand>> constraintViolations = validator.validate(brand);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    BrandExample example = new BrandExample();
                    BrandExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(brand.getId());
                    brandMapper.updateByExampleSelective(brand, example);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getList(Integer pageNum, Integer pageSize, BrandSearchVo brandSearchVo, TokenVo tokenVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        BrandExample example = new BrandExample();
        // example.setOrderByClause("`value` DESC");
        BrandExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(brandSearchVo.getName())) {
            criteria.andNameLike("%" + brandSearchVo.getName() + "%");
        }

        if (!StringUtils.isEmpty(tokenVo.getCorporationId())) {
            criteria.andCorporationIdEqualTo(tokenVo.getCorporationId());
        }
        if (!StringUtils.isEmpty(brandSearchVo.getCorporationId())) {
            criteria.andCorporationIdEqualTo(brandSearchVo.getCorporationId());
        }

        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = brandMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        try {
            return response.success(brandMapper.deleteByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}