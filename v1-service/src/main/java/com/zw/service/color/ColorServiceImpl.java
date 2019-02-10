package com.zw.service.color;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Color;
import com.zw.dao.entity.ColorExample;
import com.zw.dao.mapper.generate.ColorMapper;
import com.zw.vo.color.ColorAddVo;
import com.zw.vo.color.ColorSearchVo;
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
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorMapper colorMapper;

    @Override
    public ResponseVo add(ColorAddVo colorAddVo, String corporationId) {
        ResponseVo response = new ResponseVo();
        try {
            Color color = new Color();
            BeanUtils.copyProperties(colorAddVo, color);

            ColorExample colorExample = new ColorExample();
            ColorExample.Criteria criteria = colorExample.createCriteria();
            criteria.andNameEqualTo(color.getName());
            // 查询是否有相同
            List<Color> colors = colorMapper.selectByExample(colorExample);
            if (colors.size() == 0) {
                color.setId(new SnowFlake(1, 1).nextId());
                color.setCorporationId(Long.parseLong(corporationId));
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Color>> constraintViolations = validator.validate(color);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    colorMapper.insert(color);
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
        ResponseVo<Color> response = new ResponseVo();
        try {
            return response.success(colorMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Color color) {
        ResponseVo response = new ResponseVo();
        try {
            ColorExample colorExample = new ColorExample();
            ColorExample.Criteria criteria = colorExample.createCriteria();
            criteria.andNameEqualTo(color.getName());
            criteria.andIdNotEqualTo(color.getId());
            // 查询是否有相同
            List<Color> corporations = colorMapper.selectByExample(colorExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Color>> constraintViolations = validator.validate(color);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ColorExample example = new ColorExample();
                    ColorExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(color.getId());
                    colorMapper.updateByExampleSelective(color, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, ColorSearchVo colorSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        ColorExample example = new ColorExample();
        // example.setOrderByClause("`index_key` ASC");
        ColorExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(colorSearchVo.getName())) {
            criteria.andNameEqualTo(colorSearchVo.getName());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = colorMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        Color color = colorMapper.selectByPrimaryKey(id);
        color.setFlag((short)1);
        ColorExample example = new ColorExample();
        ColorExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(color.getId());
        colorMapper.updateByExampleSelective(color, example);
        return response.success("删除成功");
    }
}