package com.zw.service.statistics;

import com.zw.common.vo.ResponseVo;
import com.zw.vo.statistics.SProcessSearchVo;
import com.zw.vo.statistics.STicketSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午1:59
 */
public interface StatisticsService {
    ResponseVo getTicketSum(STicketSearchVo sTicketSearchVo);
    ResponseVo getUserPriceSum(SProcessSearchVo sProcessSearchVo);
}
