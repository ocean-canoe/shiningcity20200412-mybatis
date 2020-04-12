package com.shiningcity.platform.mapper;

import com.shiningcity.platform.pojo.PlatformRoleCatalog;
import com.shiningcity.platform.pojo.PlatformRoleCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformRoleCatalogMapper {
    long countByExample(PlatformRoleCatalogExample example);

    int deleteByExample(PlatformRoleCatalogExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(PlatformRoleCatalog record);

    int insertSelective(PlatformRoleCatalog record);

    List<PlatformRoleCatalog> selectByExample(PlatformRoleCatalogExample example);

    PlatformRoleCatalog selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") PlatformRoleCatalog record, @Param("example") PlatformRoleCatalogExample example);

    int updateByExample(@Param("record") PlatformRoleCatalog record, @Param("example") PlatformRoleCatalogExample example);

    int updateByPrimaryKeySelective(PlatformRoleCatalog record);

    int updateByPrimaryKey(PlatformRoleCatalog record);
}