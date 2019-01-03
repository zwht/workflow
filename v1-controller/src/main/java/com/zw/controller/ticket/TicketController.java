package com.zw.controller.ticket;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Ticket;
import com.zw.service.ticket.TicketService;
import com.zw.vo.ticket.TicketAddVo;
import com.zw.vo.ticket.TicketSearchVo;
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
@Api(description = "门")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @ApiOperation("新增")
    @PostMapping("/ticket/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody TicketAddVo ticketAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return ticketService.add(ticketAddVo, tokenVo);
    }


    @ApiOperation("详情")
    @GetMapping("/ticket/getById")
    @ResponseBody
    public ResponseVo<Ticket> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return ticketService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/ticket/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "TicketUpdateVo") @RequestBody Ticket ticket
    ) {
        return ticketService.update(ticket);
    }

    @ResponseBody
    @PostMapping("/ticket/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Ticket>>> getTicketList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "TicketSearchVo") @RequestBody TicketSearchVo ticketSearchVo,
            HttpServletRequest request
    ) {
        if (StringUtils.isEmpty(ticketSearchVo.getCorporationId())) {
            TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
            ticketSearchVo.setCorporationId(Long.parseLong(tokenVo.getCorporationId()));
        }
        return ticketService.getList(pageNum, pageSize, ticketSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/ticket/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return ticketService.del(id);
    }

    @ApiOperation("修改状态")
    @GetMapping("/ticket/updateState")
    @ResponseBody
    public ResponseVo updateState(
            @ApiParam(required = true, value = "id") @RequestParam Long id,
            @ApiParam(required = true, value = "state") @RequestParam Short state
    ) {
        return ticketService.updateState(id, state);
    }

}
