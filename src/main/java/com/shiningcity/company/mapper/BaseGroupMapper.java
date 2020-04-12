package com.shiningcity.company.mapper;

import com.shiningcity.company.pojo.BaseGroup;
import com.shiningcity.company.pojo.BaseGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseGroupMapper {
    long countByExample(BaseGroupExample example);

    int deleteByExample(BaseGroupExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(BaseGroup record);

    int insertSelective(BaseGroup record);

    List<BaseGroup> selectByExample(BaseGroupExample example);

    BaseGroup selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") BaseGroup record, @Param("example") BaseGroupExample example);

    int updateByExample(@Param("record") BaseGroup record, @Param("example") BaseGroupExample example);

    int updateByPrimaryKeySelective(BaseGroup record);

    int updateByPrimaryKey(BaseGroup record);
}