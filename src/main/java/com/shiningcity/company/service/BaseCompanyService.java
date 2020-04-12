package com.shiningcity.company.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.shiningcity.company.pojo.BaseCompany;
import com.shiningcity.company.pojo.BaseCompanyExample;

public interface BaseCompanyService {

	//增
	int insert(BaseCompany company);
	// 使用存储过程添加
	int insertProcedure(Map<String, Object> map) throws Exception;

	// 批量添加
	int insertMore(List<BaseCompany> list);
	
	//增
	int insertSelective(BaseCompany company);

	//删
	int deleteByExample(BaseCompanyExample example);

	//删
	int deleteByPrimaryKey(Integer pkid);
	
	int deleteByPrimaryKeyProcedure(Integer pkid) throws Exception;

	//改
	int updateByPrimaryKey(BaseCompany company);

	//改
	int updateByPrimaryKeySelective(BaseCompany company);

	//改
	int updateByExample(BaseCompany company, BaseCompanyExample example);

	//改
	int updateByExampleSelective(BaseCompany company, BaseCompanyExample example);

	//查
	List<BaseCompany> selectByExample(BaseCompanyExample example);

	//查
	BaseCompany selectByPrimaryKey(Integer pkid);
	
	BaseCompany selectByIdProcedure(Integer pkid) throws Exception;

	//查
	long countByExample(BaseCompanyExample example);

	//查
	List<BaseCompany> selectComDetailListByMap(Map<String, Object> map);

	//查
	List<Map<String, Object>> selectComManMapListByMap(Map<String, Object> map);

	//查
	PageInfo<Map<String, Object>> selectComManMapListPageByMap(
			Map<String, Object> map, int pageNo, int pageSize);
	
	void selectAddIntProcedure(Map<String, Object> map);
	
	void selectAddDecimalProcedure(Map<String, Object> map);

	String inputStream();
	
	String testProcedure();
}