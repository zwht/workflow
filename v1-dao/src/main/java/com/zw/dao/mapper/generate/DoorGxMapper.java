package com.zw.dao.mapper.generate;

import com.zw.dao.entity.DoorGx;
import com.zw.dao.entity.DoorGxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoorGxMapper {
    long countByExample(DoorGxExample example);

    int deleteByExample(DoorGxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DoorGx record);

    int insertSelective(DoorGx record);

    List<DoorGx> selectByExample(DoorGxExample example);

    DoorGx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DoorGx record, @Param("example") DoorGxExample example);

    int updateByExample(@Param("record") DoorGx record, @Param("example") DoorGxExample example);

    int updateByPrimaryKeySelective(DoorGx record);

    int updateByPrimaryKey(DoorGx record);
}