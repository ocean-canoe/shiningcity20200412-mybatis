package com.shiningcity.company.mapper;

import com.shiningcity.company.pojo.BaseManager;
import com.shiningcity.company.pojo.BaseManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseManagerMapper {
    long countByExample(BaseManagerExample example);

    int deleteByExample(BaseManagerExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(BaseManager record);

    int insertSelective(BaseManager record);

    List<BaseManager> selectByExample(BaseManagerExample example);

    BaseManager selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") BaseManager record, @Param("example") BaseManagerExample example);

    int updateByExample(@Param("record") BaseManager record, @Param("example") BaseManagerExample example);

    int updateByPrimaryKeySelective(BaseManager record);

    int updateByPrimaryKey(BaseManager record);
}