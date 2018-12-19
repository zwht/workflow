package com.zw.service.user;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.vo.user.UserAddVo;
import com.zw.dao.entity.User;
import com.zw.vo.user.UserSearchVo;

import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/18
 * @Time：上午11:54
 */
public interface UserService {
    ResponseVo<String> add(UserAddVo userAddVo);
    ResponseVo<User> getById(Long id);
    ResponseVo<String> update(User user);
    ResponseVo getList(Integer pageNum, Integer pageSize, UserSearchVo userSearchVo);
    ResponseVo<String> del(Long id);
}
