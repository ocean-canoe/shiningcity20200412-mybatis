package com.shiningcity.company.pojo;

import java.util.List;

public class BaseRegion {
    private Integer pkid;

    private String regionCode;

    private String regionName;

    private String shortName;

    private String parentCode;

    private Integer regionLevel;

    private String status;

    private String remarks;

    private List<BaseRegion> childList;
    
    private BaseRegion parentInfo;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public List<BaseRegion> getChildList() {
        return childList;
    }

    public void setChildList(List<BaseRegion> childList) {
        this.childList = childList;
    }

    public BaseRegion getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(BaseRegion parentInfo) {
        this.parentInfo = parentInfo;
    }

}