package com.shiningcity.company.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.shiningcity.company.pojo.BaseCompany;
import com.shiningcity.company.pojo.BaseCompanyExample;
import com.shiningcity.company.pojo.BaseCompanyExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-dao.xml"})//用于加载bean
public class BaseCompanyServiceTest {

    Logger logger = LoggerFactory.getLogger("BaseCompanyBaServiceTest");
    
    @Autowired
    BaseCompanyService companyService;
    
    //@Transactional(rollbackFor=Exception.class)
    //配置了事务传播行为，就不用再加注解了。
    @Test
    public void testInsert() {
        //fail("Not yet implemented");
        BaseCompany company = new BaseCompany();
        company.setCompanyCode("com001");
        company.setCompanyName("企业001");
        companyService.insert(company);
        System.out.println(JSON.toJSON(company));
    }
    
    @Test
    public void testInsertMore() {
        //fail("Not yet implemented");
        BaseCompany company = new BaseCompany();
        company.setCompanyCode("com001");
        company.setCompanyName("企业001");
        BaseCompany company2 = new BaseCompany();
        company2.setCompanyCode("com002");
        company2.setCompanyName("企业002");
        List<BaseCompany> list = new ArrayList<BaseCompany>();
        list.add(company);
        list.add(company2);
        int insertMore = companyService.insertMore(list);
        System.out.println("insertMoreCount="+insertMore);
        System.out.println(JSON.toJSON(list));
    }

    @Test
    public void testInsertSelective() {
        //fail("Not yet implemented");
        BaseCompany company = new BaseCompany();
        company.setCompanyCode("com001");
        company.setCompanyName("企业001");
        companyService.insertSelective(company);
    }

    //@Transactional(rollbackFor=Exception.class)
    @Test
    public void testDeleteByExample() {
        //fail("Not yet implemented");
        BaseCompanyExample example = new BaseCompanyExample();
        Criteria criteria = example.createCriteria();
        criteria.andPkidGreaterThan(3);
        companyService.deleteByExample(example);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        //fail("Not yet implemented");
        companyService.deleteByPrimaryKey(70);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        //fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateByPrimaryKeySelective() {
        //fail("Not yet implemented");
    }

    //@Transactional(rollbackFor=Exception.class)
    @Test
    public void testUpdateByExample() {
        //fail("Not yet implemented");
        BaseCompany company = new BaseCompany();
        company.setPkid(19);
        company.setCompanyCode("com008");
        company.setCompanyName("企业008");
        BaseCompanyExample example = new BaseCompanyExample();
        Criteria criteria = example.createCriteria();
        criteria.andPkidEqualTo(19);
        companyService.updateByExample(company, example);
    }

    @Test
    public void testUpdateByExampleSelective() {
        //fail("Not yet implemented");
        BaseCompany company = new BaseCompany();
        company.setPkid(6);
        company.setCompanyCode("com006");
        BaseCompanyExample example = new BaseCompanyExample();
        Criteria criteria = example.createCriteria();
        criteria.andPkidEqualTo(11);
        companyService.updateByExampleSelective(company, example);
    }

    @Test
    public void testSelectByExample() {
        //fail("Not yet implemented");
        BaseCompanyExample example = new BaseCompanyExample();
        Criteria criteria = example.createCriteria();
        criteria.andPkidEqualTo(11);
        companyService.selectByExample(example);
    }

    @Test
    public void testSelectByPrimaryKey() {
        BaseCompany company = companyService.selectByPrimaryKey(2);
        logger.warn("company={}",JSON.toJSON(company));
        //fail("Not yet implemented");
    }

    @Test
    public void testSelectComDetailListByMap() {
        //fail("Not yet implemented");
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("companyCode", "com001");
        map.put("managerName", "张");
        List<BaseCompany> comList = companyService.selectComDetailListByMap(map);
        logger.warn("comList={}",JSON.toJSONString(comList));
    }

    @Test
    public void testSelectComManMapListByMap() {
        //fail("Not yet implemented");
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("companyCode", "com001");
        map.put("managerName", "张");
        List<Map<String, Object>> comList = companyService.selectComManMapListByMap(map);
        logger.warn("comList={}",JSON.toJSONString(comList));
    }

    @Test
    public void testSelectComManMapListPageByMap() {
        //fail("Not yet implemented");
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("companyCode", "com001");
        map.put("managerName", "张");
        int pageNo = 1;
        int pageSize = 5;
        PageInfo<Map<String, Object>> pageInfo = companyService.selectComManMapListPageByMap(map,pageNo,pageSize);
        logger.warn("pageInfo={}",JSON.toJSONString(pageInfo));
    }

    @Test
    public void insertProcedure() throws Exception {
        String companyCode = "com008";String companyName = "企业008";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("companyCode", companyCode);
        map.put("companyName", companyName);
        int insertResult = companyService.insertProcedure(map);
        logger.warn("insertResult={};map={}",insertResult,JSON.toJSON(map));
    }

    @Test
    public void deleteByPrimaryKeyProcedure() throws Exception {
        Integer pkid = 3;
        int deleteResult = companyService.deleteByPrimaryKeyProcedure(pkid);
        logger.warn("deleteResult={}",deleteResult);
    }

    @Test
    public void selectByIdProcedure() throws Exception {
        Integer pkid = 6;
        BaseCompany company = companyService.selectByIdProcedure(pkid);
        logger.warn("company={}",JSON.toJSON(company));
    }
    
    @Test
    public void selectAddIntProcedure() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num1", 1);
        map.put("num2", 2);
        companyService.selectAddIntProcedure(map);
        logger.warn("map={}",JSON.toJSON(map));
    }
    
    @Test
    public void selectAddDecimalProcedure() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num1", 1.2);
        map.put("num2", 2.6);
        companyService.selectAddDecimalProcedure(map);
        logger.warn("map={}",JSON.toJSON(map));
    }
    
    @Test
    public void testTestProcedure() {
        String testProcedure = companyService.testProcedure();
        System.out.println(testProcedure);
    }

    
    //悲观锁，乐观锁，Mybatis只能模拟乐观锁，每次更改，version字段加1，hibernate可以用@Version注解。
    
    //redis
    
    //activemq
    
}
