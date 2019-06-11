package com.zw.service.statistics;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.ProcessExample;
import com.zw.dao.entity.TicketExample;
import com.zw.dao.mapper.generate.DoorMapper;
import com.zw.dao.mapper.my.StatisticsMapper;
import com.zw.vo.statistics.SProcessSearchVo;
import com.zw.vo.statistics.STicketSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:04
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    DoorMapper doorMapper;

    @Autowired
    StatisticsMapper statisticsMapper;

    @Override
    public ResponseVo getTicketSum(STicketSearchVo sTicketSearchVo) {
        ResponseVo response = new ResponseVo();
        try {
            String str="%y年%m月";
            if(sTicketSearchVo.getType()==1){
                str="%y年%m月%d日";
            }
            if(sTicketSearchVo.getType()==2){
                str="%y年%m月";
            }
            if(sTicketSearchVo.getType()==3){
                str="%y年";
            }

            //条件查询3句话
            TicketExample example = new TicketExample();
            // example.setOrderByClause("`value` DESC");
            TicketExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(sTicketSearchVo.getCorporationId())) {
                criteria.andCorporationIdEqualTo( sTicketSearchVo.getCorporationId());
            }

            if (!StringUtils.isEmpty(sTicketSearchVo.getStartTime())&&!StringUtils.isEmpty(sTicketSearchVo.getEndTime())) {
                criteria.andCreateTimeBetween(sTicketSearchVo.getStartTime(),sTicketSearchVo.getEndTime());
            }

            return response.success(statisticsMapper.getTicketSum(str, example));
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }


    @Override
    public ResponseVo getUserPriceSum(SProcessSearchVo sProcessSearchVo) {
        ResponseVo response = new ResponseVo();
        try {
            String str="%y年%m月";
            if(sProcessSearchVo.getType()==1){
                str="%y年%m月%d日";
            }
            if(sProcessSearchVo.getType()==2){
                str="%y年%m月";
            }
            if(sProcessSearchVo.getType()==3){
                str="%y年";
            }

            //条件查询3句话
            ProcessExample example = new ProcessExample();
            // example.setOrderByClause("`value` DESC");
            ProcessExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdIsNotNull();
            if (!StringUtils.isEmpty(sProcessSearchVo.getCorporationId())) {
                criteria.andCorporationIdEqualTo( sProcessSearchVo.getCorporationId());
            }
            if (!StringUtils.isEmpty(sProcessSearchVo.getStartTime())&&!StringUtils.isEmpty(sProcessSearchVo.getEndTime())) {
                criteria.andUpdateTimeBetween(sProcessSearchVo.getStartTime(),sProcessSearchVo.getEndTime());
            }
            return response.success(statisticsMapper.getUserPriceSum(str, example));
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

}