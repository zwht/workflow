package com.zw.dao.mapper.my;
import com.zw.dao.entity.TicketExample;
import com.zw.vo.ticket.TicketResponseVo;

import java.util.List;

public interface MyTicketMapper {

    List<TicketResponseVo> selectByExample(TicketExample example);
}