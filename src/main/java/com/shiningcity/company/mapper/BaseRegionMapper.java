package com.shiningcity.company.mapper;

import com.shiningcity.company.pojo.BaseRegion;
import com.shiningcity.company.pojo.BaseRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRegionMapper {
    long countByExample(BaseRegionExample example);

    int deleteByExample(BaseRegionExample example);

    int deleteByPrimaryKey(Integer pkid);

    int insert(BaseRegion record);

    int insertSelective(BaseRegion record);

    List<BaseRegion> selectByExample(BaseRegionExample example);

    BaseRegion selectByPrimaryKey(Integer pkid);

    int updateByExampleSelective(@Param("record") BaseRegion record, @Param("example") BaseRegionExample example);

    int updateByExample(@Param("record") BaseRegion record, @Param("example") BaseRegionExample example);

    int updateByPrimaryKeySelective(BaseRegion record);

    int updateByPrimaryKey(BaseRegion record);

    BaseRegion selectInfo1Test(@Param("region")BaseRegion region1,@Param("mixId")Integer mixId1);
    
    BaseRegion selectInfo2Test(@Param("regionName")String regionName1,@Param("mixId")Integer mixId1);
    
    List<BaseRegion> selectRegionListDownProcedure(String upCode);

    List<BaseRegion> selectRegionListUpProcedure(String downCode);
    
    BaseRegion selectRegionListHaveChild1(String regionCode);
    List<BaseRegion> selectRegionListHaveChild2(String regionCode);

    BaseRegion selectRegionListHaveParent(String regionCode);
    
}