package com.zw.controller.gxType;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.GxType;
import com.zw.service.gxType.GxTypeService;
import com.zw.vo.gxType.GxTypeAddVo;
import com.zw.vo.gxType.GxTypeSearchVo;
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
@Api(description = "工序")
public class GxTypeController {

    @Autowired
    private GxTypeService gxTypeService;


    @ApiOperation("新增")
    @PostMapping("/gxType/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody GxTypeAddVo gxTypeAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return gxTypeService.add(gxTypeAddVo, tokenVo.getCorporationId());
    }


    @ApiOperation("详情")
    @GetMapping("/gxType/getById")
    @ResponseBody
    public ResponseVo<GxType> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return gxTypeService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/gxType/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "GxTypeUpdateVo") @RequestBody GxType gxType
    ) {
        return gxTypeService.update(gxType);
    }

    @ResponseBody
    @PostMapping("/gxType/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<GxType>>> getGxTypeList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "GxTypeSearchVo") @RequestBody GxTypeSearchVo gxTypeSearchVo
    ) {
        return gxTypeService.getList(pageNum, pageSize, gxTypeSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/gxType/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return gxTypeService.del(id);
    }
}
