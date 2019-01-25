package com.zw.service.corporation;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Corporation;
import com.zw.dao.entity.CorporationExample;
import com.zw.dao.mapper.generate.CorporationMapper;
import com.zw.vo.corporation.CorporationAddVo;
import com.zw.vo.corporation.CorporationSearchVo;
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
public class CorporationServiceImpl implements CorporationService {

    @Autowired
    CorporationMapper corporationMapper;

    @Override
    public ResponseVo add(CorporationAddVo corporationAddVo) {
        ResponseVo response = new ResponseVo();
        try {
            Corporation corporation = new Corporation();
            BeanUtils.copyProperties(corporationAddVo, corporation);
            CorporationExample corporationExample = new CorporationExample();
            CorporationExample.Criteria criteria = corporationExample.createCriteria();
            criteria.andNameEqualTo(corporation.getName());
            // 查询是否有相同
            List<Corporation> corporations = corporationMapper.selectByExample(corporationExample);
            if (corporations.size() == 0) {
                corporation.setId(new SnowFlake(1, 1).nextId());
                corporation.setState(Short.parseShort("1101"));
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Corporation>> constraintViolations = validator.validate(corporation);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    corporationMapper.insert(corporation);
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
        ResponseVo<Corporation> response = new ResponseVo();
        try {
            return response.success(corporationMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Corporation corporation) {
        ResponseVo response = new ResponseVo();
        try {
            CorporationExample corporationExample = new CorporationExample();
            CorporationExample.Criteria criteria = corporationExample.createCriteria();
            criteria.andNameEqualTo(corporation.getName());
            criteria.andIdNotEqualTo(corporation.getId());
            // 查询是否有相同
            List<Corporation> corporations = corporationMapper.selectByExample(corporationExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Corporation>> constraintViolations = validator.validate(corporation);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    CorporationExample example = new CorporationExample();
                    CorporationExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(corporation.getId());
                    corporationMapper.updateByExampleSelective(corporation, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, CorporationSearchVo corporationSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        CorporationExample example = new CorporationExample();
        CorporationExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(corporationSearchVo.getName())) {
            criteria.andNameLike("%"+corporationSearchVo.getName()+"%");
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = corporationMapper.selectByExample(example);
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
            return response.success(corporationMapper.deleteByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}