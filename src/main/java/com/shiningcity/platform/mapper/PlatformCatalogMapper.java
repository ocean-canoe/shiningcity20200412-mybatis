package com.shiningcity.platform.mapper;

import com.shiningcity.platform.pojo.PlatformCatalog;
import com.shiningcity.platform.pojo.PlatformCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformCatalogMapper {
    long countByExample(PlatformCatalogExample example);

    int deleteByExample(PlatformCatalogExample example);

    int deleteByPrimaryKey(Integer catalogCode);

    int insert(PlatformCatalog record);

    int insertSelective(PlatformCatalog record);

    List<PlatformCatalog> selectByExample(PlatformCatalogExample example);

    PlatformCatalog selectByPrimaryKey(Integer catalogCode);

    int updateByExampleSelective(@Param("record") PlatformCatalog record, @Param("example") PlatformCatalogExample example);

    int updateByExample(@Param("record") PlatformCatalog record, @Param("example") PlatformCatalogExample example);

    int updateByPrimaryKeySelective(PlatformCatalog record);

    int updateByPrimaryKey(PlatformCatalog record);
}