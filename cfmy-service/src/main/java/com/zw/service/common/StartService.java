package com.zw.service.common;

import com.zw.common.vo.ResponseVo;
import com.zw.vo.common.LoginRequestVo;
import com.zw.vo.common.LoginResponseVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午9:52
 */
public interface StartService {
    ResponseVo<LoginResponseVo> login(LoginRequestVo loginRequestVo);
}
