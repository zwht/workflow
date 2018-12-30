package com.zw.controller.door;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Door;
import com.zw.service.door.DoorService;
import com.zw.vo.door.DoorAddVo;
import com.zw.vo.door.DoorSearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:15
 */
@RestController
@RequestMapping("/cfmy")
@Api(description = "门")
public class DoorController {

    @Autowired
    private DoorService doorService;


    @ApiOperation("新增")
    @PostMapping("/door/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody DoorAddVo doorAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return doorService.add(doorAddVo, tokenVo);
    }


    @ApiOperation("详情")
    @GetMapping("/door/getById")
    @ResponseBody
    public ResponseVo<Door> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return doorService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/door/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "DoorUpdateVo") @RequestBody Door door
    ) {
        return doorService.update(door);
    }

    @ResponseBody
    @PostMapping("/door/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Door>>> getDoorList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "DoorSearchVo") @RequestBody DoorSearchVo doorSearchVo,
            HttpServletRequest request
    ) {
        if (StringUtils.isEmpty(doorSearchVo.getCorporationId())) {
            TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
            doorSearchVo.setCorporationId(Long.parseLong(tokenVo.getCorporationId()));
        }
        return doorService.getList(pageNum, pageSize, doorSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/door/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return doorService.del(id);
    }

    @ApiOperation("修改状态")
    @GetMapping("/door/updateState")
    @ResponseBody
    public ResponseVo updateState(
            @ApiParam(required = true, value = "id") @RequestParam Long id,
            @ApiParam(required = true, value = "state") @RequestParam Short state
    ) {
        return doorService.updateState(id, state);
    }

}
