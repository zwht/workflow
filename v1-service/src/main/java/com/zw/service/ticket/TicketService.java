package com.zw.service.ticket;

import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Ticket;
import com.zw.vo.ticket.TicketAddVo;
import com.zw.vo.ticket.TicketSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface TicketService {
    ResponseVo add(TicketAddVo ticketAddVo, TokenVo tokenVo);
    ResponseVo getById(Long id);
    ResponseVo update(Ticket ticket);
    ResponseVo getList(Integer pageNum, Integer pageSize, TicketSearchVo ticketSearchVo);
    ResponseVo del(Long id);
    ResponseVo updateState(Long id, Short state);
}
