package com.zw.service.user;

import com.zw.api.UserService;
import com.zw.common.vo.ResultVo;
import com.zw.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：zhaowei
 * Date：2018/12/17
 * Time：下午3:20
 * 魏翼超然：http://120.79.171.251:9876
 * ========================
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResultVo<String> findById(Long id){
        String userRecord = userDao.getNameByUserId(id);
        return new ResultVo<>(0,userRecord);
    }

}
