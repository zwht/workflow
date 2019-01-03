package com.zw.common.util;


import com.zw.common.vo.TokenVo;

import java.util.List;

/**
 * Created by zhaowei on 2018/2/26.
 */
public class TokenUtil {

    public static void setToken(Long id, String token, int ...args) {

    }

    public static TokenVo getTokenVo(String token) {
        TokenVo tokenVo = JwtUtils.unsign(token, TokenVo.class);
        return tokenVo;
    }
}
