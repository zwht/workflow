package com.zw.service.ticket;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Ticket;
import com.zw.dao.entity.TicketExample;
import com.zw.dao.mapper.generate.TicketMapper;
import com.zw.dao.mapper.my.MyTicketMapper;
import com.zw.vo.ticket.TicketAddVo;
import com.zw.vo.ticket.TicketSearchVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:04
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketMapper ticketMapper;
    @Autowired
    MyTicketMapper myTicketMapper;

    @Override
    public ResponseVo add(TicketAddVo ticketAddVo, TokenVo tokenVo) {
        ResponseVo response = new ResponseVo();
        try {
            Ticket ticket = new Ticket();
            BeanUtils.copyProperties(ticketAddVo, ticket);
            ticket.setCorporationId(tokenVo.getCorporationId());

            TicketExample ticketExample = new TicketExample();
            TicketExample.Criteria criteria = ticketExample.createCriteria();
            criteria.andNumberEqualTo(ticket.getNumber());
            criteria.andCorporationIdEqualTo(ticket.getCorporationId());
            // 查询是否有相同
            List<Ticket> tickets = ticketMapper.selectByExample(ticketExample);
            if (tickets.size() == 0) {
                ticket.setId(new SnowFlake(1, 1).nextId());
                ticket.setCreateTime(new Timestamp(System.currentTimeMillis()));
                ticket.setState(Short.parseShort("1501"));
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Ticket>> constraintViolations = validator.validate(ticket);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    ticketMapper.insert(ticket);
                    return response.success(ticket.getId());
                }
            } else {
                return response.failure(400, "数据重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getById(Long id) {
        ResponseVo<Ticket> response = new ResponseVo();
        try {
            return response.success(ticketMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Ticket ticket) {
        ResponseVo response = new ResponseVo();
        try {
            TicketExample ticketExample = new TicketExample();
            TicketExample.Criteria criteria = ticketExample.createCriteria();
            criteria.andNameEqualTo(ticket.getName());
            criteria.andStateNotEqualTo(Short.parseShort("1500"));
            criteria.andCorporationIdEqualTo(ticket.getCorporationId());
            criteria.andIdNotEqualTo(ticket.getId());
            // 查询是否有相同
            List<Ticket> corporations = ticketMapper.selectByExample(ticketExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Ticket>> constraintViolations = validator.validate(ticket);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    TicketExample example = new TicketExample();
                    TicketExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(ticket.getId());
                    ticketMapper.updateByExampleSelective(ticket, example);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "数据重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getList(Integer pageNum, Integer pageSize, TicketSearchVo ticketSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        TicketExample example = new TicketExample();

        example.setOrderByClause("`create_time` DESC");
        TicketExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(ticketSearchVo.getNumber())) {
            criteria.andNameLike("%" + ticketSearchVo.getNumber() + "%");
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getCorporationId())) {
            criteria.andCorporationIdEqualTo(ticketSearchVo.getCorporationId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getDealersId())) {
            criteria.andDealersIdEqualTo(ticketSearchVo.getDealersId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getMarketId())) {
            criteria.andMarketIdEqualTo(ticketSearchVo.getMarketId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getEditId())) {
            criteria.andEditIdEqualTo(ticketSearchVo.getEditId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getState())&&ticketSearchVo.getState().size()>0) {
            criteria.andStateIn(ticketSearchVo.getState());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getStartTime())) {
            criteria.andCreateTimeBetween(ticketSearchVo.getStartTime(),ticketSearchVo.getEndTime());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = myTicketMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    // 获得本月第一天0点时间
    public static Date getTimesMonthmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    // 获得本月最后一天24点时间
    public static Date getTimesMonthnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    @Override
    public ResponseVo getCount(TicketSearchVo ticketSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        TicketExample example = new TicketExample();

        example.setOrderByClause("`create_time` DESC");
        TicketExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(ticketSearchVo.getNumber())) {
            criteria.andNameLike("%" + ticketSearchVo.getNumber() + "%");
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getCorporationId())) {
            criteria.andCorporationIdEqualTo(ticketSearchVo.getCorporationId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getDealersId())) {
            criteria.andDealersIdEqualTo(ticketSearchVo.getDealersId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getMarketId())) {
            criteria.andMarketIdEqualTo(ticketSearchVo.getMarketId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getEditId())) {
            criteria.andEditIdEqualTo(ticketSearchVo.getEditId());
        }
        if (!StringUtils.isEmpty(ticketSearchVo.getStartTime())) {
            criteria.andCreateTimeBetween(ticketSearchVo.getStartTime(),ticketSearchVo.getEndTime());
        }else{
            criteria.andCreateTimeBetween(getTimesMonthmorning(),getTimesMonthnight());

        }
        if (!StringUtils.isEmpty(ticketSearchVo.getState())&&ticketSearchVo.getState().size()>0) {
            criteria.andStateIn(ticketSearchVo.getState());
        }
        try {
            Page page = PageHelper.startPage(1, 1);
            List list = myTicketMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(1, 1, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }



    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        Ticket ticket = ticketMapper.selectByPrimaryKey(id);
        ticket.setFlag((short)1);
        TicketExample example = new TicketExample();
        TicketExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(ticket.getId());
        ticketMapper.updateByExampleSelective(ticket, example);
        return response.success("删除成功");
    }
  
    @Override
    public ResponseVo updateState(Long id, Short state) {
        ResponseVo response = new ResponseVo();
        Ticket ticket = ticketMapper.selectByPrimaryKey(id);
        ticket.setState(state);
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Ticket>> constraintViolations = validator.validate(ticket);

            if (constraintViolations.size() != 0) {
                return response.validation(constraintViolations);
            } else {
                TicketExample example = new TicketExample();
                TicketExample.Criteria criteria1 = example.createCriteria();
                criteria1.andIdEqualTo(ticket.getId());
                ticketMapper.updateByExampleSelective(ticket, example);
                return response.success("修改成功");
            }
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

}