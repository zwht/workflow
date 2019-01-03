package com.zw.controller.common;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.service.common.StartService;
import com.zw.vo.common.LoginRequestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午9:09
 */
@RestController
@RequestMapping("/v1")
@Api(description = "启动(登录，注册)")
public class StartController {
    @Autowired
    private StartService startService;

    @ApiOperation("登录")
    @PostMapping("/public/start/login")
    @ResponseBody
    public ResponseVo login(
            @ApiParam(required = true, value = "body内容") @RequestBody LoginRequestVo loginRequestVo
    ) {
        return startService.login(loginRequestVo, 2);
    }

    @ApiOperation("app登录")
    @PostMapping("/public/start/appLogin")
    @ResponseBody
    public ResponseVo appLogin(
            @ApiParam(required = true, value = "body内容") @RequestBody LoginRequestVo loginRequestVo
    ) {
        return startService.login(loginRequestVo, 24*7);
    }

    @ApiOperation("更新token")
    @GetMapping("/start/newToken")
    @ResponseBody
    public ResponseVo newToken(
            @ApiParam(value = "token使用时间，单位小时") @RequestParam(required=false) Integer time,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        if(StringUtils.isEmpty(time)){
            time = 2;
        }
        return startService.newToken(tokenVo,time);
    }
}
