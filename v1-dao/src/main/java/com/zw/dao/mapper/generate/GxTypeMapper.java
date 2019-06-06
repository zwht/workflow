package com.zw.dao.mapper.generate;

import com.zw.dao.entity.GxType;
import com.zw.dao.entity.GxTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GxTypeMapper {
    long countByExample(GxTypeExample example);

    int deleteByExample(GxTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GxType record);

    int insertSelective(GxType record);

    List<GxType> selectByExample(GxTypeExample example);

    GxType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GxType record, @Param("example") GxTypeExample example);

    int updateByExample(@Param("record") GxType record, @Param("example") GxTypeExample example);

    int updateByPrimaryKeySelective(GxType record);

    int updateByPrimaryKey(GxType record);
}