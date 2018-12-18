package com.zw.service.user;

import com.zw.common.vo.ResponseVo;
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
    public ResponseVo<String> add(UserAddVo userAddVo, Long userId){

        return new ResponseVo<>("");
    }

    @Override
    public ResponseVo<User> selectByPrimaryKey(Long id){
        User user = userMapper.selectByPrimaryKey(id);
        return new ResponseVo<>(0,user);
    }

}
