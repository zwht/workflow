package com.zw.controller.gx;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Gx;
import com.zw.service.gx.GxService;
import com.zw.vo.gx.GxAddVo;
import com.zw.vo.gx.GxSearchVo;
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
@Api(description = "工序")
public class GxController {

    @Autowired
    private GxService gxService;


    @ApiOperation("新增")
    @PostMapping("/gx/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody GxAddVo gxAddVo,
            HttpServletRequest request
    ) {
        if (StringUtils.isEmpty(gxAddVo.getCorporationId())) {
            TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
            gxAddVo.setCorporationId(Long.parseLong(tokenVo.getCorporationId()));
        }
        return gxService.add(gxAddVo);
    }


    @ApiOperation("详情")
    @GetMapping("/gx/getById")
    @ResponseBody
    public ResponseVo<Gx> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return gxService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/gx/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "GxUpdateVo") @RequestBody Gx gx
    ) {
        return gxService.update(gx);
    }

    @ResponseBody
    @PostMapping("/gx/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Gx>>> getGxList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "GxSearchVo") @RequestBody GxSearchVo gxSearchVo,
            HttpServletRequest request
    ) {
        if (StringUtils.isEmpty(gxSearchVo.getCorporationId())) {
            TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
            gxSearchVo.setCorporationId(Long.parseLong(tokenVo.getCorporationId()));
        }
        return gxService.getList(pageNum, pageSize, gxSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/gx/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return gxService.del(id);
    }

    @ApiOperation("修改状态")
    @GetMapping("/gx/updateState")
    @ResponseBody
    public ResponseVo updateState(
            @ApiParam(required = true, value = "id") @RequestParam Long id,
            @ApiParam(required = true, value = "state") @RequestParam Short state
    ) {
        return gxService.updateState(id, state);
    }

}
