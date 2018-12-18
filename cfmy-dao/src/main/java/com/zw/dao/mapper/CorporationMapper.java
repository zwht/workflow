package com.zw.dao.mapper;

import com.zw.dao.entity.Corporation;
import com.zw.dao.entity.CorporationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorporationMapper {
    long countByExample(CorporationExample example);

    int deleteByExample(CorporationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Corporation record);

    int insertSelective(Corporation record);

    List<Corporation> selectByExample(CorporationExample example);

    Corporation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByExample(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByPrimaryKeySelective(Corporation record);

    int updateByPrimaryKey(Corporation record);
}