package com.shiningcity.platform.mapper;

import com.shiningcity.platform.pojo.PlatformRole;
import com.shiningcity.platform.pojo.PlatformRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformRoleMapper {
    long countByExample(PlatformRoleExample example);

    int deleteByExample(PlatformRoleExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(PlatformRole record);

    int insertSelective(PlatformRole record);

    List<PlatformRole> selectByExample(PlatformRoleExample example);

    PlatformRole selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") PlatformRole record, @Param("example") PlatformRoleExample example);

    int updateByExample(@Param("record") PlatformRole record, @Param("example") PlatformRoleExample example);

    int updateByPrimaryKeySelective(PlatformRole record);

    int updateByPrimaryKey(PlatformRole record);
}