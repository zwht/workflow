package com.zw.controller.codeGroup;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.CodeGroup;
import com.zw.service.codeGroup.CodeGroupService;
import com.zw.vo.codeGroup.CodeGroupAddVo;
import com.zw.vo.codeGroup.CodeGroupSearchVo;
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
@RequestMapping("/v1")
@Api(description = "码表组")
public class CodeGroupController {

    @Autowired
    private CodeGroupService codeGroupService;


    @ApiOperation("新增")
    @PostMapping("/codeGroup/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody CodeGroupAddVo codeGroupAddVo
    ) {
        return codeGroupService.add(codeGroupAddVo);
    }


    @ApiOperation("详情")
    @GetMapping("/codeGroup/getById")
    @ResponseBody
    public ResponseVo<CodeGroup> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return codeGroupService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/codeGroup/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "CodeGroupUpdateVo") @RequestBody CodeGroup codeGroup
    ) {
        return codeGroupService.update(codeGroup);
    }

    @ResponseBody
    @PostMapping("/codeGroup/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<CodeGroup>>> getCodeGroupList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "CodeGroupSearchVo") @RequestBody CodeGroupSearchVo codeGroupListFind
    ) {
        return codeGroupService.getList(pageNum, pageSize, codeGroupListFind);
    }


    @ApiOperation("删除")
    @GetMapping("/codeGroup/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return codeGroupService.del(id);
    }
}
