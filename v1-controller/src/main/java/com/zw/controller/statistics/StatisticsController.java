package com.zw.controller.statistics;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Door;
import com.zw.service.door.DoorService;
import com.zw.service.statistics.StatisticsService;
import com.zw.vo.door.DoorSearchVo;
import com.zw.vo.statistics.SProcessResponseVo;
import com.zw.vo.statistics.SProcessSearchVo;
import com.zw.vo.statistics.STicketResponseVo;
import com.zw.vo.statistics.STicketSearchVo;
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
@Api(description = "统计接口")
public class StatisticsController {

    @Autowired
    private DoorService doorService;

    @Autowired
    private StatisticsService statisticsService;


    @ApiOperation("根据条件查询工单数量")
    @PostMapping("/public/statistics/getTicketSum")
    @ResponseBody
    public ResponseVo<List<STicketResponseVo>> getTicketSum(
            @ApiParam(value = "DoorSearchVo") @RequestBody STicketSearchVo sTicketSearchVo,
            HttpServletRequest request
    ) {
        if (StringUtils.isEmpty(sTicketSearchVo.getCorporationId())) {
            TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
            sTicketSearchVo.setCorporationId(tokenVo.getCorporationId());
        }
        return statisticsService.getTicketSum(sTicketSearchVo);
    }

    @ApiOperation("根据条件查询员工工资")
    @PostMapping("/public/statistics/getUserPriceSum")
    @ResponseBody
    public ResponseVo<List<SProcessResponseVo>> getUserPriceSum(
            @ApiParam(value = "DoorSearchVo") @RequestBody SProcessSearchVo sProcessSearchVo,
            HttpServletRequest request
    ) {
        if (StringUtils.isEmpty(sProcessSearchVo.getCorporationId())) {
            TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
            sProcessSearchVo.setCorporationId(tokenVo.getCorporationId());
        }
        return statisticsService.getUserPriceSum(sProcessSearchVo);
    }

}
