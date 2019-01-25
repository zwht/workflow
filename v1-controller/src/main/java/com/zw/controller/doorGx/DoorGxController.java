package com.zw.controller.doorDoorGx;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.DoorGx;
import com.zw.service.doorGx.DoorGxService;
import com.zw.vo.doorGx.DoorGxAddVo;
import com.zw.vo.doorGx.DoorGxSearchVo;
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
@RequestMapping("/v1")
@Api(description = "工序")
public class DoorGxController {

    @Autowired
    private DoorGxService doorGxService;


    @ApiOperation("新增")
    @PostMapping("/doorGx/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody DoorGxAddVo doorGxAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return doorGxService.add(doorGxAddVo, tokenVo.getCorporationId());
    }


    @ApiOperation("详情")
    @GetMapping("/doorGx/getById")
    @ResponseBody
    public ResponseVo<DoorGx> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return doorGxService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/doorGx/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "DoorGxUpdateVo") @RequestBody DoorGx doorGx
    ) {
        return doorGxService.update(doorGx);
    }

    @ResponseBody
    @PostMapping("/doorGx/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<DoorGx>>> getDoorGxList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "DoorGxSearchVo") @RequestBody DoorGxSearchVo doorGxSearchVo
    ) {
        return doorGxService.getList(pageNum, pageSize, doorGxSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/doorGx/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return doorGxService.del(id);
    }
}
