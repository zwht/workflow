package com.zw.dao.mapper.generate;

import com.zw.dao.entity.Door;
import com.zw.dao.entity.DoorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoorMapper {
    long countByExample(DoorExample example);

    int deleteByExample(DoorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Door record);

    int insertSelective(Door record);

    List<Door> selectByExample(DoorExample example);

    Door selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Door record, @Param("example") DoorExample example);

    int updateByExample(@Param("record") Door record, @Param("example") DoorExample example);

    int updateByPrimaryKeySelective(Door record);

    int updateByPrimaryKey(Door record);
}