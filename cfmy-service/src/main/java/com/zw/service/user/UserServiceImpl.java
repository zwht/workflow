package com.zw.service.user;

import com.zw.api.UserService;
import com.zw.common.vo.ResultVo;
import com.zw.common.vo.user.UserAddVo;
import org.springframework.stereotype.Service;

/**
 * @author：zhaowei
 * @Date：2018/12/18
 * @Time：上午11:54
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public ResultVo<String> add(UserAddVo userAddVo, Long userId){

        return new ResultVo<>("");
    }

    @Override
    public ResultVo<String> findById(Long id){
        return new ResultVo<>(0,"44");
    }

}
