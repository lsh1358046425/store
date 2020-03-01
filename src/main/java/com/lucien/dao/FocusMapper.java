package com.lucien.dao;

import com.lucien.po.Focus;
import com.lucien.po.FocusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FocusMapper {
    long countByExample(FocusExample example);

    int deleteByExample(FocusExample example);

    int deleteByPrimaryKey(Integer focusId);

    int insert(Focus record);

    int insertSelective(Focus record);

    List<Focus> selectByExample(FocusExample example);

    Focus selectByPrimaryKey(Integer focusId);

    int updateByExampleSelective(@Param("record") Focus record, @Param("example") FocusExample example);

    int updateByExample(@Param("record") Focus record, @Param("example") FocusExample example);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
}