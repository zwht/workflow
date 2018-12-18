package com.zw.dao;

import com.zw.model.Code;
import java.util.List;

public interface CodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Code record);

    Code selectByPrimaryKey(Long id);

    List<Code> selectAll();

    int updateByPrimaryKey(Code record);
}