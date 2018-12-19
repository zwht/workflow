package com.zw.service.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.util.ZwUtil;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.vo.user.UserAddVo;
import com.zw.dao.entity.User;
import com.zw.dao.entity.UserExample;
import com.zw.dao.mapper.UserMapper;
import com.zw.vo.user.UserSearchVo;
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
 * @Date：2018/12/18
 * @Time：上午11:54
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseVo<String> add(UserAddVo userAddVo) {
        ResponseVo response = new ResponseVo();
        try {
            User user = new User();
            BeanUtils.copyProperties(userAddVo, user);
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andLoginNameEqualTo(user.getLoginName());
            //使用用户名查询是否有相同用户名
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size() == 0) {
                user.setId(new SnowFlake(1, 1).nextId());
                ZwUtil zwUtil = new ZwUtil();
                user.setPassword(zwUtil.EncoderByMd5(user.getPassword()));
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    userMapper.insert(user);
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
    public ResponseVo<User> getById(Long id) {
        ResponseVo<User> response = new ResponseVo<User>();
        try {
            return response.success(userMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo<String> update(User user) {
        ResponseVo response = new ResponseVo();
        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andLoginNameEqualTo(user.getLoginName());
            criteria.andIdNotEqualTo(user.getId());
            //使用用户名查询是否有相同用户名
            List<User> corporations = userMapper.selectByExample(userExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    UserExample example = new UserExample();
                    UserExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(user.getId());
                    userMapper.updateByExampleSelective(user, example);
                    //corporationMapper.insert(corporation);
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
    public ResponseVo getList(Integer pageNum, Integer pageSize, UserSearchVo userSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andCorporationIdEqualTo(userSearchVo.getCorporationId());
        if (!StringUtils.isEmpty(userSearchVo.getRoles())) {
            criteria.andRolesEqualTo(userSearchVo.getRoles());
        }
        if (!StringUtils.isEmpty(userSearchVo.getName())) {
            criteria.andNameEqualTo(userSearchVo.getName());
        }
        if (!StringUtils.isEmpty(userSearchVo.getLoginName())) {
            criteria.andLoginNameEqualTo(userSearchVo.getLoginName());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = userMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo<String> del(Long id) {
        ResponseVo response = new ResponseVo();
        try {
            return response.success(userMapper.deleteByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}
