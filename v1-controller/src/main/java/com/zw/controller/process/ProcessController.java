package com.zw.controller.process;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Process;
import com.zw.service.process.ProcessService;
import com.zw.vo.process.ProcessAddVo;
import com.zw.vo.process.ProcessSearchVo;
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
@Api(description = "工单工序总价格")
public class ProcessController {

    @Autowired
    private ProcessService processService;


    @ApiOperation("新增")
    @PostMapping("/process/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody ProcessAddVo[] processAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return processService.add(processAddVo, tokenVo);
    }


    @ApiOperation("详情")
    @GetMapping("/process/getById")
    @ResponseBody
    public ResponseVo<Process> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return processService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/process/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "ProcessUpdateVo") @RequestBody Process process
    ) {
        return processService.update(process);
    }

    @ResponseBody
    @PostMapping("/process/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Process>>> getProcessList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "ProcessSearchVo") @RequestBody ProcessSearchVo processSearchVo,
            HttpServletRequest request
    ) {
        return processService.getList(pageNum, pageSize, processSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/process/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return processService.del(id);
    }

    @ApiOperation("修改状态")
    @GetMapping("/process/updateState")
    @ResponseBody
    public ResponseVo updateState(
            @ApiParam(required = true, value = "id") @RequestParam Long id,
            @ApiParam(required = true, value = "state") @RequestParam Short state
    ) {
        return processService.updateState(id, state);
    }

}
