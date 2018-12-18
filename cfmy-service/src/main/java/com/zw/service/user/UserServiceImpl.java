package com.zw.service.user;

import com.zw.common.vo.ResultVo;
import com.zw.common.vo.user.UserAddVo;
import com.zw.dao.entity.User;
import com.zw.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ResultVo<String> add(UserAddVo userAddVo, Long userId){

        return new ResultVo<>("");
    }

    @Override
    public ResultVo<User> selectByPrimaryKey(Long id){
        User user = userMapper.selectByPrimaryKey(id);
        return new ResultVo<>(0,user);
    }

}
