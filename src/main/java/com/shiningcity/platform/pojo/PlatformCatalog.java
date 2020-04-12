package com.shiningcity.platform.pojo;

public class PlatformCatalog {
    private Integer catalogCode;

    private String catalogName;

    private Integer parentCatalogCode;

    private Integer sort;

    private String catalogPaht;

    private Integer showStatus;

    private String remark;

    public Integer getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(Integer catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public Integer getParentCatalogCode() {
        return parentCatalogCode;
    }

    public void setParentCatalogCode(Integer parentCatalogCode) {
        this.parentCatalogCode = parentCatalogCode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCatalogPaht() {
        return catalogPaht;
    }

    public void setCatalogPaht(String catalogPaht) {
        this.catalogPaht = catalogPaht == null ? null : catalogPaht.trim();
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}