package com.zw.service.gxType;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.GxType;
import com.zw.dao.entity.GxTypeExample;
import com.zw.dao.mapper.generate.GxTypeMapper;
import com.zw.vo.gxType.GxTypeAddVo;
import com.zw.vo.gxType.GxTypeSearchVo;
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
public class GxTypeServiceImpl implements GxTypeService {

    @Autowired
    GxTypeMapper gxTypeMapper;

    @Override
    public ResponseVo add(GxTypeAddVo gxTypeAddVo, Long corporationId) {
        ResponseVo response = new ResponseVo();
        try {
            GxType gxType = new GxType();
            BeanUtils.copyProperties(gxTypeAddVo, gxType);

            GxTypeExample gxTypeExample = new GxTypeExample();
            GxTypeExample.Criteria criteria = gxTypeExample.createCriteria();
            criteria.andGxIdEqualTo(gxType.getGxId());
            // 查询是否有相同
            List<GxType> gxTypes = gxTypeMapper.selectByExample(gxTypeExample);
            if (gxTypes.size() == 0) {
                gxType.setId(new SnowFlake(1, 1).nextId());
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<GxType>> constraintViolations = validator.validate(gxType);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    gxTypeMapper.insert(gxType);
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
        ResponseVo<GxType> response = new ResponseVo();
        try {
            return response.success(gxTypeMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(GxType gxType) {
        ResponseVo response = new ResponseVo();
        try {
            GxTypeExample gxTypeExample = new GxTypeExample();
            GxTypeExample.Criteria criteria = gxTypeExample.createCriteria();
            criteria.andGxIdEqualTo(gxType.getGxId());
            criteria.andIdNotEqualTo(gxType.getId());
            // 查询是否有相同
            List<GxType> corporations = gxTypeMapper.selectByExample(gxTypeExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<GxType>> constraintViolations = validator.validate(gxType);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    GxTypeExample example = new GxTypeExample();
                    GxTypeExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(gxType.getId());
                    gxTypeMapper.updateByExampleSelective(gxType, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, GxTypeSearchVo gxTypeSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        GxTypeExample example = new GxTypeExample();
        example.setOrderByClause("`index_key` ASC");
        GxTypeExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(gxTypeSearchVo.getGxId())) {
            criteria.andGxIdEqualTo(gxTypeSearchVo.getGxId());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = gxTypeMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        GxType gxType = gxTypeMapper.selectByPrimaryKey(id);
        gxType.setFlag((short)1);
        GxTypeExample example = new GxTypeExample();
        GxTypeExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(gxType.getId());
        gxTypeMapper.updateByExampleSelective(gxType, example);
        return response.success("删除成功");
    }
}