package com.zw.service.codeGroup;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.CodeGroup;
import com.zw.dao.entity.CodeGroupExample;
import com.zw.dao.mapper.generate.CodeGroupMapper;
import com.zw.vo.codeGroup.CodeGroupAddVo;
import com.zw.vo.codeGroup.CodeGroupSearchVo;
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
public class CodeGroupServiceImpl implements CodeGroupService {

    @Autowired
    CodeGroupMapper codeGroupMapper;

    @Override
    public ResponseVo add(CodeGroupAddVo codeGroupAddVo) {
        ResponseVo response = new ResponseVo();
        try {
            CodeGroup codeGroup = new CodeGroup();
            BeanUtils.copyProperties(codeGroupAddVo, codeGroup);
            CodeGroupExample codeGroupExample = new CodeGroupExample();
            CodeGroupExample.Criteria criteria = codeGroupExample.createCriteria();
            criteria.andValueEqualTo(codeGroup.getValue());
            // 查询是否有相同
            List<CodeGroup> codeGroups = codeGroupMapper.selectByExample(codeGroupExample);
            if (codeGroups.size() == 0) {
                codeGroup.setId(new SnowFlake(1, 1).nextId());
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<CodeGroup>> constraintViolations = validator.validate(codeGroup);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    codeGroupMapper.insert(codeGroup);
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
        ResponseVo<CodeGroup> response = new ResponseVo();
        try {
            return response.success(codeGroupMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(CodeGroup codeGroup) {
        ResponseVo response = new ResponseVo();
        try {
            CodeGroupExample codeGroupExample = new CodeGroupExample();
            CodeGroupExample.Criteria criteria = codeGroupExample.createCriteria();
            criteria.andValueEqualTo(codeGroup.getValue());
            criteria.andIdNotEqualTo(codeGroup.getId());
            // 查询是否有相同
            List<CodeGroup> corporations = codeGroupMapper.selectByExample(codeGroupExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<CodeGroup>> constraintViolations = validator.validate(codeGroup);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    CodeGroupExample example = new CodeGroupExample();
                    CodeGroupExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(codeGroup.getId());
                    codeGroupMapper.updateByExampleSelective(codeGroup, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, CodeGroupSearchVo codeGroupSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        CodeGroupExample example = new CodeGroupExample();
        CodeGroupExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(codeGroupSearchVo.getName())) {
            criteria.andNameLike("%"+codeGroupSearchVo.getName()+"%");
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = codeGroupMapper.selectByExample(example);
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
            return response.success(codeGroupMapper.deleteByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}