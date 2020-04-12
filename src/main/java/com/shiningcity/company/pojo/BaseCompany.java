package com.shiningcity.company.pojo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class BaseCompany {
    private Integer pkid;
    
    private String companyCode;

    private String companyName;

    private String companyAddress;

    private String firstManagerName;

    private String certificateCode;

    private String firstManagerTelephone;

    private String groupCode;

    private String regionCode;
    //1对1
    private BaseGroup group;
    //1对1
    private BaseRegion region;
    //1对多
    private List<BaseManager> managerList;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getFirstManagerName() {
        return firstManagerName;
    }

    public void setFirstManagerName(String firstManagerName) {
        this.firstManagerName = firstManagerName == null ? null : firstManagerName.trim();
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }

    public String getFirstManagerTelephone() {
        return firstManagerTelephone;
    }

    public void setFirstManagerTelephone(String firstManagerTelephone) {
        this.firstManagerTelephone = firstManagerTelephone == null ? null : firstManagerTelephone.trim();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

	public BaseGroup getGroup() {
		return group;
	}

	public void setGroup(BaseGroup group) {
		this.group = group;
	}

	public List<BaseManager> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<BaseManager> managerList) {
		this.managerList = managerList;
	}

	public BaseRegion getRegion() {
		return region;
	}

	public void setRegion(BaseRegion region) {
		this.region = region;
	}
    
}