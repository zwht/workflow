package com.zw.dao;

import com.zw.model.Corporation;
import java.util.List;

public interface CorporationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Corporation record);

    Corporation selectByPrimaryKey(Long id);

    List<Corporation> selectAll();

    int updateByPrimaryKey(Corporation record);
}