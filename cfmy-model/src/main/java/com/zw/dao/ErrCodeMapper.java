package com.zw.dao;

import com.zw.model.ErrCode;
import java.util.List;

public interface ErrCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ErrCode record);

    ErrCode selectByPrimaryKey(Long id);

    List<ErrCode> selectAll();

    int updateByPrimaryKey(ErrCode record);
}