package com.shiningcity.common.pojo;

import java.util.List;

public class BasePage<T> {
	
	private Integer pageNo;
	private Integer pageSize;
	private Long totalCount;
	private Long totalPage;
	private List<T> result;
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		//this.totalPage = totalPage;
		if (this.totalCount>0&&this.pageSize>0) {
			if (this.totalCount%this.pageSize>0) {
				this.totalPage = this.totalCount/this.pageSize;
			}else {
				this.totalPage = this.totalCount/this.pageSize+1;
			}
		}else {
			this.totalPage = 0L;
		}
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public BasePage(Integer pageNo, Integer pageSize, Long totalCount, List<T> result) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.result = result;
	}
	
	
	
	
}
