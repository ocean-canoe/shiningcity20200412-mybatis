package com.shiningcity.company.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiningcity.company.mapper.BaseCompanyMapper;
import com.shiningcity.company.mapper.BaseGroupMapper;
import com.shiningcity.company.mapper.BaseManagerMapper;
import com.shiningcity.company.pojo.BaseCompany;
import com.shiningcity.company.pojo.BaseCompanyExample;

//此处不用添加transactional注解
@Service
public class BaseManagerServiceImpl implements BaseManagerService {
	
	Logger logger = LoggerFactory.getLogger(BaseManagerServiceImpl.class);

	@Autowired
	private BaseManagerMapper managerMapper;

	@Override
	public String index(int i) {
		System.out.println("index"+i);
		return "index"+i;
	}
	
}
