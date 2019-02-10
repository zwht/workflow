package com.zw.service.door;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Door;
import com.zw.dao.entity.DoorExample;
import com.zw.dao.mapper.generate.DoorMapper;
import com.zw.vo.door.DoorAddVo;
import com.zw.vo.door.DoorSearchVo;
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
public class DoorServiceImpl implements DoorService {

    @Autowired
    DoorMapper doorMapper;

    @Override
    public ResponseVo add(DoorAddVo doorAddVo, TokenVo tokenVo) {
        ResponseVo response = new ResponseVo();
        try {
            Door door = new Door();
            BeanUtils.copyProperties(doorAddVo, door);
            door.setCorporationId(Long.parseLong(tokenVo.getCorporationId()));

            DoorExample doorExample = new DoorExample();
            DoorExample.Criteria criteria = doorExample.createCriteria();
            criteria.andNameEqualTo(door.getName());
            criteria.andCorporationIdEqualTo(door.getCorporationId());
            // 查询是否有相同
            List<Door> doors = doorMapper.selectByExample(doorExample);
            if (doors.size() == 0) {
                door.setId(new SnowFlake(1, 1).nextId());
                door.setCreateTime(new Timestamp(System.currentTimeMillis()));
                door.setState(Short.parseShort("1401"));
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Door>> constraintViolations = validator.validate(door);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    doorMapper.insert(door);
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
        ResponseVo<Door> response = new ResponseVo();
        try {
            return response.success(doorMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Door door) {
        ResponseVo response = new ResponseVo();
        try {
            DoorExample doorExample = new DoorExample();
            DoorExample.Criteria criteria = doorExample.createCriteria();
            criteria.andNameEqualTo(door.getName());
            criteria.andCorporationIdEqualTo(door.getCorporationId());
            criteria.andIdNotEqualTo(door.getId());
            // 查询是否有相同
            List<Door> corporations = doorMapper.selectByExample(doorExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Door>> constraintViolations = validator.validate(door);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    DoorExample example = new DoorExample();
                    DoorExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(door.getId());
                    doorMapper.updateByExampleSelective(door, example);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, DoorSearchVo doorSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        DoorExample example = new DoorExample();
        example.setOrderByClause("`sum` DESC");
        DoorExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(doorSearchVo.getName())) {
            criteria.andNameLike("%" + doorSearchVo.getName() + "%");
        }
        if (!StringUtils.isEmpty(doorSearchVo.getNumber())) {
            criteria.andNumberLike("%" + doorSearchVo.getNumber() + "%");
        }
        if (!StringUtils.isEmpty(doorSearchVo.getCorporationId())) {
            criteria.andCorporationIdEqualTo(doorSearchVo.getCorporationId());
        }
        if (!StringUtils.isEmpty(doorSearchVo.getType())) {
            String[] l = doorSearchVo.getType().split(",");
            List<Short> o = new ArrayList<>();
            for (int i = 0 ; i <l.length ; i++ ) {
                o.add(Short.parseShort(l[i]));
            }
            criteria.andTypeIn(o);
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = doorMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        Door door = doorMapper.selectByPrimaryKey(id);
        door.setFlag((short)1);
        DoorExample example = new DoorExample();
        DoorExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(door.getId());
        doorMapper.updateByExampleSelective(door, example);
        return response.success("删除成功");
    }
    @Override
    public ResponseVo updateState(Long id, Short state) {
        ResponseVo response = new ResponseVo();
        Door door = doorMapper.selectByPrimaryKey(id);
        door.setState(state);
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Door>> constraintViolations = validator.validate(door);

            if (constraintViolations.size() != 0) {
                return response.validation(constraintViolations);
            } else {
                DoorExample example = new DoorExample();
                DoorExample.Criteria criteria1 = example.createCriteria();
                criteria1.andIdEqualTo(door.getId());
                doorMapper.updateByExampleSelective(door, example);
                return response.success("修改成功");
            }
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}