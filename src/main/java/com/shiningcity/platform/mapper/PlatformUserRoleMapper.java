package com.shiningcity.platform.mapper;

import com.shiningcity.platform.pojo.PlatformUserRole;
import com.shiningcity.platform.pojo.PlatformUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformUserRoleMapper {
    long countByExample(PlatformUserRoleExample example);

    int deleteByExample(PlatformUserRoleExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(PlatformUserRole record);

    int insertSelective(PlatformUserRole record);

    List<PlatformUserRole> selectByExample(PlatformUserRoleExample example);

    PlatformUserRole selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") PlatformUserRole record, @Param("example") PlatformUserRoleExample example);

    int updateByExample(@Param("record") PlatformUserRole record, @Param("example") PlatformUserRoleExample example);

    int updateByPrimaryKeySelective(PlatformUserRole record);

    int updateByPrimaryKey(PlatformUserRole record);
}