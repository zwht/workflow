package com.zw.controller.user;

import com.zw.dao.user.UserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：zhaowei
 * Date：2018/12/15
 * Time：下午5:35
 * 魏翼超然：http://120.79.171.251:9876
 * ========================
 */
@RestController
@RequestMapping("/v1/user")
@Api(value = "/v1/user", description = "用户")
public class UserController {
    @Autowired
    UserDao userDao;

    @GetMapping("/add")
    @ApiOperation(value = "添加用户", notes = "添加", httpMethod = "GET")
    public String add(HttpServletRequest request) {

        String sd=userDao.getNameByUserId(Long.parseLong("1"));
        return sd;

    }
}
