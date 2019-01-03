package com.zw.service.gx;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Gx;
import com.zw.dao.entity.GxExample;
import com.zw.dao.mapper.generate.GxMapper;
import com.zw.vo.gx.GxAddVo;
import com.zw.vo.gx.GxSearchVo;
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
public class GxServiceImpl implements GxService {

    @Autowired
    GxMapper gxMapper;

    @Override
    public ResponseVo add(GxAddVo gxAddVo, String corporationId) {
        ResponseVo response = new ResponseVo();
        try {
            Gx gx = new Gx();
            BeanUtils.copyProperties(gxAddVo, gx);
            gx.setCorporationId(Long.parseLong(corporationId));
            GxExample gxExample = new GxExample();
            GxExample.Criteria criteria = gxExample.createCriteria();
            criteria.andNameEqualTo(gx.getName());
            criteria.andStateNotEqualTo(Short.parseShort("1200"));
            criteria.andCorporationIdEqualTo(gx.getCorporationId());
            // 查询是否有相同
            List<Gx> gxs = gxMapper.selectByExample(gxExample);
            if (gxs.size() == 0) {
                gx.setId(new SnowFlake(1, 1).nextId());
                gx.setState(Short.parseShort("1201"));
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Gx>> constraintViolations = validator.validate(gx);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    gxMapper.insert(gx);
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
        ResponseVo<Gx> response = new ResponseVo();
        try {
            return response.success(gxMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Gx gx) {
        ResponseVo response = new ResponseVo();
        try {
            GxExample gxExample = new GxExample();
            GxExample.Criteria criteria = gxExample.createCriteria();
            criteria.andNameEqualTo(gx.getName());
            criteria.andStateNotEqualTo(Short.parseShort("1200"));
            criteria.andCorporationIdEqualTo(gx.getCorporationId());
            criteria.andIdNotEqualTo(gx.getId());
            // 查询是否有相同
            List<Gx> corporations = gxMapper.selectByExample(gxExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Gx>> constraintViolations = validator.validate(gx);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    GxExample example = new GxExample();
                    GxExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(gx.getId());
                    gxMapper.updateByExampleSelective(gx, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, GxSearchVo gxSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        GxExample example = new GxExample();
        example.setOrderByClause("`index_key` ASC");
        GxExample.Criteria criteria = example.createCriteria();
        criteria.andStateNotEqualTo(Short.parseShort("1200"));
        if (!StringUtils.isEmpty(gxSearchVo.getName())) {
            criteria.andNameLike("%" + gxSearchVo.getName() + "%");
        }
        if (!StringUtils.isEmpty(gxSearchVo.getCorporationId())) {
            criteria.andCorporationIdEqualTo(gxSearchVo.getCorporationId());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = gxMapper.selectByExample(example);
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
            return response.success(gxMapper.deleteByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo updateState(Long id, Short state) {
        ResponseVo response = new ResponseVo();
        Gx gx = gxMapper.selectByPrimaryKey(id);
        gx.setState(state);
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Gx>> constraintViolations = validator.validate(gx);

            if (constraintViolations.size() != 0) {
                return response.validation(constraintViolations);
            } else {
                GxExample example = new GxExample();
                GxExample.Criteria criteria1 = example.createCriteria();
                criteria1.andIdEqualTo(gx.getId());
                gxMapper.updateByExampleSelective(gx, example);
                return response.success("修改成功");
            }
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}