package com.zw.controller.code;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Code;
import com.zw.service.code.CodeService;
import com.zw.vo.code.CodeAddVo;
import com.zw.vo.code.CodeSearchVo;
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
@RequestMapping("/cfmy")
@Api(description = "码表")
public class CodeController {

    @Autowired
    private CodeService codeService;


    @ApiOperation("新增")
    @PostMapping("/code/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody CodeAddVo codeAddVo
    ) {
        return codeService.add(codeAddVo);
    }


    @ApiOperation("详情")
    @GetMapping("/code/getById")
    @ResponseBody
    public ResponseVo<Code> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return codeService.getById(id);
    }

    @ApiOperation("更新")
    @PostMapping("/code/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "CodeUpdateVo") @RequestBody Code code
    ) {
        return codeService.update(code);
    }

    @ResponseBody
    @PostMapping("/public/code/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Code>>> getCodeList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "CodeSearchVo") @RequestBody CodeSearchVo codeListFind,
            HttpServletRequest request
    ) {
        return codeService.getList(pageNum, pageSize, codeListFind);
    }


    @ApiOperation("删除")
    @GetMapping("/code/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return codeService.del(id);
    }
}
