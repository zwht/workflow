package com.zw.controller.common;

import com.zw.common.vo.ResponseVo;
import com.zw.service.common.StartService;
import com.zw.vo.common.LoginRequestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午9:09
 */
@RestController
@RequestMapping("/cfmy")
@Api(description = "启动(登录，注册)")
public class StartController {
    @Autowired
    private StartService startService;

    @ApiOperation("登录")
    @PostMapping("/public/start/login")
    @ResponseBody
    public ResponseVo login(
            @ApiParam(required = true, value = "body内容") @RequestBody LoginRequestVo loginRequestVo,
            HttpServletRequest request
    ) {
        return startService.login(loginRequestVo);
    }
}
