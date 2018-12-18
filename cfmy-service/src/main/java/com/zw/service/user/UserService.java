package com.zw.service.user;

import com.zw.common.vo.ResultVo;
import com.zw.common.vo.user.UserAddVo;
import com.zw.model.User;

/**
 * @author：zhaowei
 * @Date：2018/12/18
 * @Time：上午11:54
 */
public interface UserService {
    /**
     * 添加用户
     * @param userAddVo
     * @param userId
     * @return
     * @throws Exception
     */
    ResultVo<String> add(UserAddVo userAddVo, Long userId);

    /**
     * 根据id查询用户详情
     * @param id
     * @return
     */
    ResultVo<User> selectByPrimaryKey(Long id);
}
