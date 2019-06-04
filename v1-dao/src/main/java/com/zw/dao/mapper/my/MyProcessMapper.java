package com.zw.dao.mapper.my;
import com.zw.dao.entity.ProcessExample;
import com.zw.vo.process.ProcessResponseVo;

import java.util.List;

public interface MyProcessMapper {

    List<ProcessResponseVo> selectByExample(ProcessExample example);
}