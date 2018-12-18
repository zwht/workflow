package com.zw.controller.user;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.user.UserAddVo;
import com.zw.dao.entity.User;
import com.zw.service.user.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * User：zhaowei
 * Date：2018/12/15
 * Time：下午5:35
 */
@RestController
@RequestMapping("/v1/user")
@Api(value = "/v1/user", description = "用户")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @PostMapping("/user/add")
    @ApiOperation("新增")
    public ResponseVo add(
            @ApiParam(required = true, value = "AddUserVo", name = "AddUserVo") @RequestBody UserAddVo userAddVo,
            HttpServletRequest request
    ) {
        // TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        // userAddVo.setCorporationId(tokenVo.getCorporationId());
        return userService.add(userAddVo);
    }


    @ResponseBody
    @GetMapping("/user/getById")
    @ApiOperation("详情")
    public ResponseVo<User> selectByPrimaryKey(
            @ApiParam(value = "用户Id", defaultValue = "121") @RequestParam Long id
    ) {
        return userService.getById(id);
    }


    @ResponseBody
    @PostMapping("/user/update")
    @ApiOperation("更新")
    public ResponseVo update(
            @ApiParam(required = true, value = "UserUpdateVo") @RequestBody User user
    ) {
        return userService.update(user);
    }

//    @ResponseBody
//    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
//    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
//    public ResponseVo<PageVo<List<User>>> getUserList(
//            @ApiParam(required = true, value = "当前页面", name = "pageNum") @RequestParam Integer pageNum,
//            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @RequestParam Integer pageSize,
//            @ApiParam(required = true, value = "userListFind", name = "userListFind") @RequestBody UserListFind userListFind,
//            HttpServletRequest request
//    ) {
//        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
//        userListFind.setCorporationId(tokenVo.getCorporationId());
//        return userService.getList(pageNum, pageSize, userListFind);
//    }


    @ResponseBody
    @GetMapping("/user/del")
    @ApiOperation("删除")
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return userService.del(id);
    }
}
