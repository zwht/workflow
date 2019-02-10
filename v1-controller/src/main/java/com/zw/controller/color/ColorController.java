package com.zw.controller.color;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Color;
import com.zw.service.color.ColorService;
import com.zw.vo.color.ColorAddVo;
import com.zw.vo.color.ColorSearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(description = "颜色")
public class ColorController {

    @Autowired
    private ColorService colorService;


    @ApiOperation("新增")
    @PostMapping("/color/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody ColorAddVo colorAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return colorService.add(colorAddVo, tokenVo.getCorporationId());
    }


    @ApiOperation("详情")
    @GetMapping("/color/getById")
    @ResponseBody
    public ResponseVo<Color> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return colorService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/color/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "ColorUpdateVo") @RequestBody Color color
    ) {
        return colorService.update(color);
    }

    @ResponseBody
    @PostMapping("/color/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Color>>> getColorList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "ColorSearchVo") @RequestBody ColorSearchVo colorSearchVo
    ) {
        return colorService.getList(pageNum, pageSize, colorSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/color/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return colorService.del(id);
    }
}
