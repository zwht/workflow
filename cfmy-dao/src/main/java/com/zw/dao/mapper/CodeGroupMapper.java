package com.zw.dao.mapper;

import com.zw.dao.entity.CodeGroup;
import com.zw.dao.entity.CodeGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeGroupMapper {
    long countByExample(CodeGroupExample example);

    int deleteByExample(CodeGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CodeGroup record);

    int insertSelective(CodeGroup record);

    List<CodeGroup> selectByExample(CodeGroupExample example);

    CodeGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CodeGroup record, @Param("example") CodeGroupExample example);

    int updateByExample(@Param("record") CodeGroup record, @Param("example") CodeGroupExample example);

    int updateByPrimaryKeySelective(CodeGroup record);

    int updateByPrimaryKey(CodeGroup record);
}