package com.shiningcity.platform.mapper;

import com.shiningcity.platform.pojo.PlatformUser;
import com.shiningcity.platform.pojo.PlatformUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformUserMapper {
    long countByExample(PlatformUserExample example);

    int deleteByExample(PlatformUserExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    List<PlatformUser> selectByExample(PlatformUserExample example);

    PlatformUser selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") PlatformUser record, @Param("example") PlatformUserExample example);

    int updateByExample(@Param("record") PlatformUser record, @Param("example") PlatformUserExample example);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByPrimaryKey(PlatformUser record);
}