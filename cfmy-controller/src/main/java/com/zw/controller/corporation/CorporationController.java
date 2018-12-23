package com.zw.controller.corporation;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Corporation;
import com.zw.service.corporation.CorporationService;
import com.zw.vo.corporation.CorporationAddVo;
import com.zw.vo.corporation.CorporationSearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:15
 */
@RestController
@RequestMapping("/cfmy")
@Api(description = "码表组")
public class CorporationController {

    @Autowired
    private CorporationService corporationService;


    @ApiOperation("新增")
    @PostMapping("/corporation/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody CorporationAddVo corporationAddVo
    ) {
        return corporationService.add(corporationAddVo);
    }


    @ApiOperation("详情")
    @GetMapping("/corporation/getById")
    @ResponseBody
    public ResponseVo<Corporation> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return corporationService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/corporation/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "CorporationUpdateVo") @RequestBody Corporation corporation
    ) {
        return corporationService.update(corporation);
    }

    @ResponseBody
    @PostMapping("/corporation/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Corporation>>> getCorporationList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "CorporationSearchVo") @RequestBody CorporationSearchVo corporationListFind
    ) {
        return corporationService.getList(pageNum, pageSize, corporationListFind);
    }


    @ApiOperation("删除")
    @GetMapping("/corporation/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return corporationService.del(id);
    }
}
