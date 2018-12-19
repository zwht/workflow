package com.zw.controller.user;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.vo.user.UserAddVo;
import com.zw.dao.entity.User;
import com.zw.service.user.UserService;
import com.zw.vo.user.UserSearchVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User：zhaowei
 * Date：2018/12/15
 * Time：下午5:35
 */
@RestController
@RequestMapping("/cfmy/user")
@Api(description = "用户")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("新增")
    @PostMapping("/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody UserAddVo userAddVo,
            HttpServletRequest request
    ) {
        // TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        // userAddVo.setCorporationId(tokenVo.getCorporationId());
        return userService.add(userAddVo);
    }


    @ApiOperation("详情")
    @GetMapping("/getById")
    @ResponseBody
    public ResponseVo<User> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id", defaultValue = "121") @RequestParam Long id
    ) {
        return userService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "UserUpdateVo") @RequestBody User user
    ) {
        return userService.update(user);
    }

    @ResponseBody
    @PostMapping("/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<User>>> getUserList(
            @ApiParam(required = true, value = "当前页面", example = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", example = "10") @RequestParam Integer pageSize,
            @ApiParam(required = true, value = "UserSearchVo") @RequestBody UserSearchVo userListFind,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        userListFind.setCorporationId(tokenVo.getCorporationId());
        return userService.getList(pageNum, pageSize, userListFind);
    }


    @ApiOperation("删除")
    @GetMapping("/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return userService.del(id);
    }
}
