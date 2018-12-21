package com.zw.service.code;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Code;
import com.zw.dao.entity.CodeExample;
import com.zw.dao.mapper.generate.CodeMapper;
import com.zw.vo.code.CodeAddVo;
import com.zw.vo.code.CodeSearchVo;
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
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeMapper codeMapper;

    @Override
    public ResponseVo add(CodeAddVo codeAddVo) {
        ResponseVo response = new ResponseVo();
        try {
            Code code = new Code();
            BeanUtils.copyProperties(codeAddVo, code);
            CodeExample codeExample = new CodeExample();
            CodeExample.Criteria criteria = codeExample.createCriteria();
            criteria.andNameEqualTo(code.getName());
            // 查询是否有相同
            List<Code> codes = codeMapper.selectByExample(codeExample);
            if (codes.size() == 0) {
                code.setId(new SnowFlake(1, 1).nextId());
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Code>> constraintViolations = validator.validate(code);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    codeMapper.insert(code);
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
        ResponseVo<Code> response = new ResponseVo();
        try {
            return response.success(codeMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Code code) {
        ResponseVo response = new ResponseVo();
        try {
            CodeExample codeExample = new CodeExample();
            CodeExample.Criteria criteria = codeExample.createCriteria();
            criteria.andNameEqualTo(code.getName());
            criteria.andIdNotEqualTo(code.getId());
            // 查询是否有相同
            List<Code> corporations = codeMapper.selectByExample(codeExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Code>> constraintViolations = validator.validate(code);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    CodeExample example = new CodeExample();
                    CodeExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(code.getId());
                    codeMapper.updateByExampleSelective(code, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, CodeSearchVo codeSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        CodeExample example = new CodeExample();
        CodeExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(codeSearchVo.getName())) {
            criteria.andNameLike("%"+codeSearchVo.getName()+"%");
        }
        if (!StringUtils.isEmpty(codeSearchVo.getGroupId())) {
            criteria.andGroupIdEqualTo(codeSearchVo.getGroupId());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = codeMapper.selectByExample(example);
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
            return response.success(codeMapper.deleteByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}