package com.zw.dao.mapper.generate;

import com.zw.dao.entity.Color;
import com.zw.dao.entity.ColorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColorMapper {
    long countByExample(ColorExample example);

    int deleteByExample(ColorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Color record);

    int insertSelective(Color record);

    List<Color> selectByExample(ColorExample example);

    Color selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Color record, @Param("example") ColorExample example);

    int updateByExample(@Param("record") Color record, @Param("example") ColorExample example);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);
}