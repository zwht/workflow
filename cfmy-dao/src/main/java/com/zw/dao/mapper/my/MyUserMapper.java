package com.zw.dao.mapper.my;
import com.zw.dao.entity.UserExample;
import com.zw.vo.user.UserResponseVo;

import java.util.List;

public interface MyUserMapper {

    List<UserResponseVo> selectByExample(UserExample example);
}