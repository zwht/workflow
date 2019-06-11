package com.zw.dao.mapper.my;

import com.zw.dao.entity.CodeExample;
import com.zw.dao.entity.ProcessExample;
import com.zw.dao.entity.TicketExample;
import com.zw.vo.code.CodeResponseVo;
import com.zw.vo.statistics.STicketResponseVo;

import java.util.Date;
import java.util.List;

/**
 * MyCodeMapper接口，处理code关联查询
 * @author：zhaowei
 */
public interface StatisticsMapper {
    /**
     * 关联查询code列表
     *  @param example 查询对象
     *  @return Code
     */
    List<STicketResponseVo> getTicketSum(String str, TicketExample example);

    /**
     * 关联查询code列表
     *  @param example 查询对象
     *  @return Code
     */
    List<STicketResponseVo> getUserPriceSum(String str, ProcessExample example);

}
