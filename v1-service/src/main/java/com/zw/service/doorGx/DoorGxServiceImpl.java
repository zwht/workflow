package com.zw.service.doorGx;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.DoorGx;
import com.zw.dao.entity.DoorGxExample;
import com.zw.dao.mapper.generate.DoorGxMapper;
import com.zw.vo.doorGx.DoorGxAddVo;
import com.zw.vo.doorGx.DoorGxSearchVo;
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
public class DoorGxServiceImpl implements DoorGxService {

    @Autowired
    DoorGxMapper doorGxMapper;

    @Override
    public ResponseVo add(DoorGxAddVo doorGxAddVo, String corporationId) {
        ResponseVo response = new ResponseVo();
        try {
            DoorGx doorGx = new DoorGx();
            BeanUtils.copyProperties(doorGxAddVo, doorGx);

            DoorGxExample doorGxExample = new DoorGxExample();
            DoorGxExample.Criteria criteria = doorGxExample.createCriteria();
            criteria.andDoorIdEqualTo(doorGx.getDoorId());
            criteria.andGxIdEqualTo(doorGx.getGxId());
            // 查询是否有相同
            List<DoorGx> doorGxs = doorGxMapper.selectByExample(doorGxExample);
            if (doorGxs.size() == 0) {
                doorGx.setId(new SnowFlake(1, 1).nextId());
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<DoorGx>> constraintViolations = validator.validate(doorGx);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    doorGxMapper.insert(doorGx);
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
        ResponseVo<DoorGx> response = new ResponseVo();
        try {
            return response.success(doorGxMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(DoorGx doorGx) {
        ResponseVo response = new ResponseVo();
        try {
            DoorGxExample doorGxExample = new DoorGxExample();
            DoorGxExample.Criteria criteria = doorGxExample.createCriteria();
            criteria.andDoorIdEqualTo(doorGx.getDoorId());
            criteria.andGxIdEqualTo(doorGx.getGxId());
            criteria.andIdNotEqualTo(doorGx.getId());
            // 查询是否有相同
            List<DoorGx> corporations = doorGxMapper.selectByExample(doorGxExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<DoorGx>> constraintViolations = validator.validate(doorGx);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    DoorGxExample example = new DoorGxExample();
                    DoorGxExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(doorGx.getId());
                    doorGxMapper.updateByExampleSelective(doorGx, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, DoorGxSearchVo doorGxSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        DoorGxExample example = new DoorGxExample();
        example.setOrderByClause("`index_key` ASC");
        DoorGxExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(doorGxSearchVo.getDoorId())) {
            criteria.andDoorIdEqualTo(doorGxSearchVo.getDoorId());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = doorGxMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        DoorGx doorGx = doorGxMapper.selectByPrimaryKey(id);
        doorGx.setFlag((short)1);
        DoorGxExample example = new DoorGxExample();
        DoorGxExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(doorGx.getId());
        doorGxMapper.updateByExampleSelective(doorGx, example);
        return response.success("删除成功");
    }
}