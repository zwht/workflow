package com.zw.service.process;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Process;
import com.zw.dao.entity.ProcessExample;
import com.zw.dao.mapper.generate.ProcessMapper;
import com.zw.vo.process.ProcessAddVo;
import com.zw.vo.process.ProcessSearchVo;
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
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public ResponseVo add(ProcessAddVo[] processList, TokenVo tokenVo) {
        ResponseVo response = new ResponseVo();
        try {
            // 修改成功，然后删除所有公司，在添加公司
            ProcessExample processExample = new ProcessExample();
            ProcessExample.Criteria criteria2 = processExample.createCriteria();
            criteria2.andTicketIdEqualTo(processList[0].getTicketId());
            processMapper.deleteByExample(processExample);

            
            for(int i=0;i<processList.length;i++){
                Process process = new Process();
                BeanUtils.copyProperties(processList[i], process);
                process.setCorporationId(tokenVo.getCorporationId());

                process.setId(new SnowFlake(1, 1).nextId());
                process.setState(1601);
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Process>> constraintViolations = validator.validate(process);
                if (constraintViolations.size() != 0) {
                    // return response.validation(constraintViolations);
                } else {
                    processMapper.insert(process);
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
        ResponseVo<Process> response = new ResponseVo();
        try {
            return response.success(processMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Process process) {
        ResponseVo response = new ResponseVo();
        try {
            ProcessExample processExample = new ProcessExample();
            ProcessExample.Criteria criteria = processExample.createCriteria();
            criteria.andCorporationIdEqualTo(process.getCorporationId());
            criteria.andIdNotEqualTo(process.getId());
            // 查询是否有相同
            List<Process> corporations = processMapper.selectByExample(processExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Process>> constraintViolations = validator.validate(process);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ProcessExample example = new ProcessExample();
                    ProcessExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(process.getId());
                    processMapper.updateByExampleSelective(process, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, ProcessSearchVo processSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        ProcessExample example = new ProcessExample();
        // example.setOrderByClause("`sum` DESC");
        ProcessExample.Criteria criteria = example.createCriteria();
        // criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(processSearchVo.getTicketId())) {
            criteria.andTicketIdEqualTo(processSearchVo.getTicketId());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = processMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        Process process = processMapper.selectByPrimaryKey(id);
        process.setFlag((short)1);
        ProcessExample example = new ProcessExample();
        ProcessExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(process.getId());
        processMapper.updateByExampleSelective(process, example);
        return response.success("删除成功");
    }
    @Override
    public ResponseVo updateState(Long id, Short state) {
        ResponseVo response = new ResponseVo();
        Process process = processMapper.selectByPrimaryKey(id);
        process.setState(Integer.valueOf(state));
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Process>> constraintViolations = validator.validate(process);

            if (constraintViolations.size() != 0) {
                return response.validation(constraintViolations);
            } else {
                ProcessExample example = new ProcessExample();
                ProcessExample.Criteria criteria1 = example.createCriteria();
                criteria1.andIdEqualTo(process.getId());
                processMapper.updateByExampleSelective(process, example);
                return response.success("修改成功");
            }
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}