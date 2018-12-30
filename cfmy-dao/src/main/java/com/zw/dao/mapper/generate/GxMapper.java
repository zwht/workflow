package com.zw.dao.mapper.generate;

import com.zw.dao.entity.Gx;
import com.zw.dao.entity.GxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GxMapper {
    long countByExample(GxExample example);

    int deleteByExample(GxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Gx record);

    int insertSelective(Gx record);

    List<Gx> selectByExample(GxExample example);

    Gx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Gx record, @Param("example") GxExample example);

    int updateByExample(@Param("record") Gx record, @Param("example") GxExample example);

    int updateByPrimaryKeySelective(Gx record);

    int updateByPrimaryKey(Gx record);
}