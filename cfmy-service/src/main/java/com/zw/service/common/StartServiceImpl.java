package com.zw.service.common;

import com.zw.common.util.JwtUtils;
import com.zw.common.util.TokenUtil;
import com.zw.common.util.ZwUtil;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.User;
import com.zw.dao.entity.UserExample;
import com.zw.dao.mapper.UserMapper;
import com.zw.vo.common.LoginRequestVo;
import com.zw.vo.common.LoginResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午9:52
 */
@Service
public class StartServiceImpl implements StartService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseVo<LoginResponseVo> login(LoginRequestVo loginRequestVo){

        ResponseVo<LoginResponseVo> response = new ResponseVo();
        try {
            if (StringUtils.isEmpty(loginRequestVo.getLoginName())) {
                throw new Exception("登录名不能为空!");
            }
            if (StringUtils.isEmpty(loginRequestVo.getPassword())) {
                throw new Exception("密码不能为空!");
            }
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andLoginNameEqualTo(loginRequestVo.getLoginName());
            //使用登录名查询是否有相同用户名
            List<User> users = userMapper.selectByExample(userExample);


            ZwUtil zwUtil = new ZwUtil();
            if (users.size() == 0) {
                return response.failure(400, "登录名或者密码错误！");
            } else if (users.get(0).getPassword().equals(zwUtil.EncoderByMd5(loginRequestVo.getPassword()))) {
                User userOne = users.get(0);
                TokenVo tokenVo = new TokenVo();
                // 把user对象属性赋值给tokenVo对象
                BeanUtils.copyProperties(userOne, tokenVo);
                // 设置jwt过期时间为2小时
                String token = JwtUtils.sign(tokenVo, 1000 * 60 * 60 * 2);
                LoginResponseVo loginResponseVo=new LoginResponseVo();
                BeanUtils.copyProperties(userOne, loginResponseVo);
                loginResponseVo.setToken(token);

                return response.success(loginResponseVo);
            } else {
                return response.failure(400, "密码错误！");
            }

        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }
}
