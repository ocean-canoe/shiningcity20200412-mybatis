package com.shiningcity.company.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiningcity.company.mapper.BaseCompanyMapper;
import com.shiningcity.company.mapper.BaseGroupMapper;
import com.shiningcity.company.mapper.BaseRegionMapper;
import com.shiningcity.company.pojo.BaseCompany;
import com.shiningcity.company.pojo.BaseCompanyExample;
import com.shiningcity.company.pojo.BaseRegion;

//此处不用添加transactional注解
@Service
public class BaseCompanyServiceImpl implements BaseCompanyService {
	
	Logger logger = LoggerFactory.getLogger("BaseCompanyServiceImpl");

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
	@Autowired
	private BaseCompanyMapper companyMapper;
	@Autowired
	private BaseGroupMapper groupMapper;
    @Autowired
    private BaseRegionMapper regionMapper;
    
	//封装session的返回
    public SqlSession getSession() throws IOException{
    	//Reader reader = Resources.getResourceAsReader(resource);
    	
    	//用Resources，com前边不能带/
        //String resource = "com/shiningcity/company/mapper/BaseCompanyMapper.xml";
        //InputStream inputStream = Resources.getResourceAsStream(resource);
    	
    	//用BaseCompanyServiceImpl.class，com前边需要带/
    	//String resource = "/com/shiningcity/company/mapper/BaseCompanyMapper.xml";   // 单个mapper
        String resource = "/com/shiningcity/company/mapper/*.xml";      // 多个mapper
        InputStream inputStream = BaseCompanyServiceImpl.class.getResourceAsStream(resource);
        
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //操作数据库的类 SqlSession
        SqlSession session=sqlSessionFactory.openSession(true);
        return session;
    }

    //封装session的返回
    public SqlSession getSession2() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //String resource = "com.shiningcity.company.mapper.BaseCompanyMapper.xml";   // 单个mapper
        String resource = "com.shiningcity.company.mapper.*.xml";      // 多个mapper
        //注意：此步一定要添加mapper.xml文件扫描路径，否则报错Invalid bound statement (not found)
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(resource));
        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
        //操作数据库的类 SqlSession
        SqlSession session=sqlSessionFactory.openSession(true);
        return session;
    }
    
	//增
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#insert(com.shiningcity.company.pojo.BaseCompany)
	 */
	public int insert(BaseCompany company){
		//companyMapper.insertSelective(company);
		int i = companyMapper.insert(company);
			//int[] ii = new int[1];
			//ii[2] = 5;
		return i;
	}
	
	// 批量添加
	public int insertMore(List<BaseCompany> list) {
	    int insertMore = companyMapper.insertMore(list);
	    return insertMore;
	}
	
	//增
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#insertSelective(com.shiningcity.company.pojo.BaseCompany)
	 */
	public int insertSelective(BaseCompany company){
		return companyMapper.insertSelective(company);
	}
	
	//删
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#deleteByExample(com.shiningcity.company.pojo.BaseCompanyExample)
	 */
	public int deleteByExample(BaseCompanyExample example){
		return companyMapper.deleteByExample(example);
	}
	
	//删
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#deleteByPrimaryKey(java.lang.Integer)
	 */
	public int deleteByPrimaryKey(Integer pkid){
		return companyMapper.deleteByPrimaryKey(pkid);
	}
	
	//改
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#updateByPrimaryKey(com.shiningcity.company.pojo.BaseCompany)
	 */
	public int updateByPrimaryKey(BaseCompany company){
		return companyMapper.updateByPrimaryKey(company);
	}
	
	//改
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#updateByPrimaryKeySelective(com.shiningcity.company.pojo.BaseCompany)
	 */
	public int updateByPrimaryKeySelective(BaseCompany company){
		return companyMapper.updateByPrimaryKeySelective(company);
	}
	
	//改
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#updateByExample(com.shiningcity.company.pojo.BaseCompany, com.shiningcity.company.pojo.BaseCompanyExample)
	 */
	public int updateByExample(BaseCompany company,BaseCompanyExample example){
		int i = companyMapper.updateByExample(company, example);
			//int[] ii = new int[1];
			//ii[2] = 5;
		return i;
	}
	
	//改
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#updateByExampleSelective(com.shiningcity.company.pojo.BaseCompany, com.shiningcity.company.pojo.BaseCompanyExample)
	 */
	public int updateByExampleSelective(BaseCompany company,BaseCompanyExample example){
		return companyMapper.updateByExampleSelective(company, example);
	}
	
	//查
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#selectByExample(com.shiningcity.company.pojo.BaseCompanyExample)
	 */
	public List<BaseCompany> selectByExample(BaseCompanyExample example){
		return companyMapper.selectByExample(example);
	}
	
	//查
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#selectByPrimaryKey(java.lang.Integer)
	 */
	public BaseCompany selectByPrimaryKey(Integer pkid){
		logger.warn("BaseCompanyBaService.selectByPrimaryKey()被调用");
		return companyMapper.selectByPrimaryKey(pkid);
	}
	
	//查
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#countByExample(com.shiningcity.company.pojo.BaseCompanyExample)
	 */
	public long countByExample(BaseCompanyExample example){
		return companyMapper.countByExample(example);
	}
	
	//查
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#selectComDetailListByMap(java.util.Map)
	 */
	public List<BaseCompany> selectComDetailListByMap(Map<String, Object> map){
		//Criteria criteria = example.createCriteria();
		return companyMapper.selectComDetailListByMap(map);
	}

	//查
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#selectComManMapListByMap(java.util.Map)
	 */
	public List<Map<String, Object>> selectComManMapListByMap(Map<String, Object> map){
		//Criteria criteria = example.createCriteria();
		return companyMapper.selectComManMapListByMap(map);
	}
	
	//查
	/* (non-Javadoc)
	 * @see com.shiningcity.company.service.BaseCompanyService#selectComManMapListPageByMap(java.util.Map, int, int)
	 */
	public PageInfo<Map<String, Object>> selectComManMapListPageByMap(Map<String, Object> map, int pageNo, int pageSize){
		//Criteria criteria = example.createCriteria();
		Page<Object> startPage = PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = companyMapper.selectComManMapListByMap(map);
			//logger.warn("list={}",JSON.toJSONString(list));
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
			//logger.warn("pageInfo={}",JSON.toJSONString(pageInfo));
		return pageInfo;
	}

	// 使用存储过程添加
	@Override
	public int insertProcedure(Map<String, Object> map) throws Exception {
		//SqlSession session = getSession();
		//BaseCompanyMapper mapper = session.getMapper(BaseCompanyMapper.class);
		//mapper.insertProcedure(map);
		//logger.warn(JSON.toJSONString(map));
		//return 0;
		int insertResult = companyMapper.insertProcedure(map);
		return insertResult;
	}

	@Override
	public int deleteByPrimaryKeyProcedure(Integer pkid) throws Exception {
//		SqlSession session = getSession();
//		BaseCompanyMapper mapper = session.getMapper(BaseCompanyMapper.class);
//		mapper.deleteByPrimaryKeyProcedure(pkid);
		int deleteResult = companyMapper.deleteByPrimaryKeyProcedure(pkid);
		return deleteResult;
	}

	@Override
	public BaseCompany selectByIdProcedure(Integer pkid) throws Exception {
//		SqlSession session = getSession();
//		BaseCompanyMapper mapper = session.getMapper(BaseCompanyMapper.class);
//		BaseCompany company = mapper.selectByIdProcedure(pkid);
		BaseCompany company = companyMapper.selectByIdProcedure(pkid);
		return company;
	}

	@Override
	public void selectAddIntProcedure(Map<String, Object> map) {
		companyMapper.selectAddIntProcedure(map);
	}

	@Override
	public void selectAddDecimalProcedure(Map<String, Object> map) {
		companyMapper.selectAddDecimalProcedure(map);
	}

	@Override
	public String inputStream() {
		//读取文件
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		//保存文件
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			File inFile = new File("D://eclipse workspace//workspace03//file//myfile.txt");
			File outFile = new File("D://eclipse workspace//workspace03//file//myOutFile.txt");
			if (inFile.isFile() && inFile.exists()) {
				
				//读
				fis = new FileInputStream(inFile);	//字节流读取文件
				isr = new InputStreamReader(fis, "GBK");	//字节流转为字符流	utf-8无法解决部分文档中文乱码问题，GBK和GB2312可以解决，视文档的编码格式而定。
				br = new BufferedReader(isr);	//读取文本的缓冲区
				
				//写
				fos = new FileOutputStream(outFile,true);	//字节流
				osw = new OutputStreamWriter(fos,"utf-8");	//字节流转为字符流
				bw = new BufferedWriter(osw);	//写文本的缓冲区
				
				//读
				String str = null;
				while ((str = br.readLine())!=null) {
					logger.warn("读取一行文本内容：{}",str);
					
					//写
					bw.newLine();
					bw.write(str);
					bw.flush();
				}
				
			}
			/*
	因为计算机是洋鬼子发明的，它们的英文字符占一个字节，而我们的中文是一个字符，占俩字节。
	如果用stream，你读出来的英语再倒也罢了，读出来的中文可就是乱码或者一个个“？？？？”。
	所以需要把字节流转为字符流
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("{}",e);
			return "ERROR";
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				logger.error("{}",e);
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				logger.error("{}",e);
			}
		}
		return "OK";
	}
	
	//{"s1":{"age":16,"name":"s1"},"s2":{"$ref":"$.s1"}}
	//解决方法：禁用循环引用DisableCircularReferenceDetect
	//SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 

    @Override
    public String testProcedure() {
        
        BaseRegion region = new BaseRegion();
        region.setRegionName("河北省");
        BaseRegion region1 = regionMapper.selectInfo1Test(region, 600);
        logger.warn("region1 = {}",JSON.toJSONString(region1));
        
        BaseRegion region2 = regionMapper.selectInfo2Test("河北省", 600);
        logger.warn("region2 = {}",JSON.toJSONString(region2));
        
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("upCode", "01");
        map2.put("downCode", "010101");
        List<BaseRegion> regionList1 = regionMapper.selectRegionListDownProcedure("01");
        List<BaseRegion> regionList2 = regionMapper.selectRegionListUpProcedure("010101");
        logger.warn("regionList1 = {}",JSON.toJSONString(regionList1));
        logger.warn("regionList2 = {}",JSON.toJSONString(regionList2));
        
        BaseRegion regionList3 = regionMapper.selectRegionListHaveChild1("01");
        BaseRegion regionList4 = regionMapper.selectRegionListHaveParent("010101");
        while (regionList4.getParentCode()!=null) {
            List<BaseRegion> childList = new ArrayList<BaseRegion>();
            BaseRegion info = new BaseRegion();
            info.setParentCode(regionList4.getParentCode());
            info.setPkid(regionList4.getPkid());
            info.setRegionCode(regionList4.getRegionCode());
            info.setRegionLevel(regionList4.getRegionLevel());
            info.setRegionName(regionList4.getRegionName());
            info.setShortName(regionList4.getShortName());
            info.setStatus(regionList4.getStatus());
            info.setChildList(regionList4.getChildList());
            childList.add(info);
            regionList4 = regionList4.getParentInfo();
            regionList4.setChildList(childList);
        }
        logger.warn("regionList3 = {}",JSON.toJSONString(regionList3));
        logger.warn("regionList4 = {}",JSON.toJSONString(regionList4));
        return "OK";
    }

}
