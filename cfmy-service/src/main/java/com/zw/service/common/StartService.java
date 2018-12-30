package com.zw.service.common;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.vo.common.LoginRequestVo;
import com.zw.vo.common.LoginResponseVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午9:52
 */
public interface StartService {
    ResponseVo login(LoginRequestVo loginRequestVo, Integer time);
    ResponseVo newToken(TokenVo tokenVo, Integer time);
}
