package com.shiningcity.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shiningcity.company.pojo.BaseCompanyExample;
import com.shiningcity.company.pojo.BaseCompanyExample.Criteria;
import com.shiningcity.company.service.BaseCompanyService;

/**
 * 从配置文件中获得bean，创建对象。
 * @Author dikaihui
 * @Date 2019年7月13日
 */
public class GetFromSpringXML {
	public static void main(String[] args) {
		//初始化spring容器，会调用被容器托管的类的无参构造方法，如果xml中配置了property，会调用类的set方法对配置的属性赋值。
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml");
		
		BaseCompanyService companyBaService = ac.getBean(BaseCompanyService.class);//通过类名引用，如果容器中有多个同名的类，会报错。
		//BaseCompanyBaService companyBaService = ac.getBean("id");//如果是通过<bean>标签配置的类，可以通过id引用。需要强转类型，
		BaseCompanyExample example = new BaseCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompanyNameLike("%企业%");
		long count = companyBaService.countByExample(example);
		System.out.println(count);
	}
}
