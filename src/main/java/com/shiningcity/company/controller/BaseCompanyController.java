package com.shiningcity.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.github.pagehelper.PageInfo;
import com.shiningcity.common.test.TestSpringContextHolder;
import com.shiningcity.company.pojo.BaseCompany;
import com.shiningcity.company.service.BaseCompanyService;

/*
关于跨域：
注解@CrossOrigin
出于安全原因，浏览器禁止Ajax调用驻留在当前原点之外的资源。例如，当你在一个标签中检查你的银行账户时，你可以在另一个选项卡上拥有EVILL网站。来自EVILL的脚本不能够对你的银行API做出Ajax请求（从你的帐户中取出钱！）使用您的凭据。
跨源资源共享（CORS）是由大多数浏览器实现的W3C规范，允许您灵活地指定什么样的跨域请求被授权，而不是使用一些不太安全和不太强大的策略，如IFRAME或JSONP。
Spring Framework 4.2 GA为CORS提供了第一类支持，使您比通常的基于过滤器的解决方案更容易和更强大地配置它。所以springMVC的版本要在4.2或以上版本才支持@CrossOrigin

方法一：
//您可以向@RequestMapping注解处理程序方法添加一个@CrossOrigin注解，以便启用CORS（默认情况下，@CrossOrigin允许在@RequestMapping注解中指定的所有源和HTTP方法）

其中@CrossOrigin中的2个参数：
origins：允许可访问的域列表
maxAge：准备响应前的缓存持续的最大时间（以秒为单位）。

同时使用controller和方法级别的CORS配置，Spring将合并两个注释属性以创建合并的CORS配置。

如果您正在使用Spring Security，请确保在Spring安全级别启用CORS，并允许它利用Spring MVC级别定义的配置。
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()...
    }
}

方法二：
除了细粒度、基于注释的配置之外，您还可能需要定义一些全局CORS配置。这类似于使用筛选器，但可以声明为Spring MVC并结合细粒度@CrossOrigin配置。默认情况下，所有origins and GET, HEAD and POST methods是允许的。
例如：com.shiningcity.company.controller.WebConfig
//全局CORS配置
//如果您正在使用Spring Security，请确保在Spring安全级别启用CORS，并允许它利用Spring MVC级别定义的配置。
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
        	.allowedOrigins("http://domain2.com")
        	.allowedMethods("PUT", "DELETE")
        	.allowedHeaders("header1", "header2", "header3")
        	.exposedHeaders("header1", "header2")
        	.allowCredentials(false)
        	.maxAge(3600);
    }
}
如果您正在使用Spring Boot，建议将WebMvcConfigurer bean声明如下：
@Configuration
public class MyConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}

方法三：
还可以将CORS与MVC XML命名空间配置。
a、如果整个项目所有方法都可以访问，则可以这样配置；此最小XML配置使CORS在/**路径模式具有与JavaConfig相同的缺省属性：
<mvc:cors>  
    <mvc:mapping path="/api/**"/>  其中* 表示匹配到下一层；** 表示后面不管有多少层，都能匹配。
</mvc:cors> 

b、也可以用定制属性声明几个CORS映射：
<mvc:cors>
    <mvc:mapping path="/api/**"
        allowed-origins="http://domain1.com, http://domain2.com"
        allowed-methods="GET, PUT"
        allowed-headers="header1, header2, header3"
        exposed-headers="header1, header2" 
        allow-credentials="false"
        max-age="123" />
    <mvc:mapping path="/resources/**"
        allowed-origins="http://domain1.com" />
</mvc:cors>

c、如果使用Spring Security，不要忘记在Spring安全级别启用CORS：
<http>
    <!-- Default to Spring MVC's CORS configuration -->
    <cors />
    ...
</http>

方法四：
作为上述其他方法的替代，Spring框架还提供了CorsFilter。在这种情况下，不用使用@CrossOrigin或WebMvcConfigurer#addCorsMappings(CorsRegistry)
例如，可以在Spring Boot应用程序中声明如下的过滤器：
@Configuration
public class MyConfiguration {
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://domain1.com");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}


spring注解@CrossOrigin不起作用的原因
1、是springMVC的版本要在4.2或以上版本才支持@CrossOrigin
2、非@CrossOrigin没有解决跨域请求问题，而是不正确的请求导致无法得到预期的响应，导致浏览器端提示跨域问题。
3、在Controller注解上方添加@CrossOrigin注解后，仍然出现跨域问题，解决方案之一就是：
在@RequestMapping注解中没有指定Get、Post方式，具体指定后，问题解决。

 *
 */
//@RestController	//@RestController是@ResponseBody和@Controller的结合
//@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@Controller
@RequestMapping("/{urlParam}/company")
public class BaseCompanyController {
	Logger logger = LoggerFactory.getLogger(BaseCompanyController.class);
	
	@Value("${testKey}")	//在springmvc.xml中引入xx.properties配置文件。
	private String testValue;
	@Value("${testKey}")
	private Integer testValue2;
	
	@Autowired
	private BaseCompanyService companyService;

    @Resource(name="threadPool")//@Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入，而@Resource默认按 byName自动注入罢了。
    private ThreadPoolTaskExecutor threadPool;//线程池（单例模式，线程泄露的风险极低）
    //@Autowired    //（同上）
    //private ThreadPoolTaskExecutor threadPool;

	// 参数校验
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(@RequestParam(required = true,defaultValue = "hello") String hello,
	        @NotNull String world,
	        @Size(max = 6,min = 2) String shining,
	        @Pattern(regexp = "")String city,  // 正则表达式
	        @Max(value = 1000) @Min(value = 10)Integer user,
	        @Min(value = 10) Integer name,
	        @Past Date abc,    // 是否在当前时间之前
	        @Future Date def,   // 是否在当前时间之后
	        @AssertTrue Boolean pass,
	        @AssertFalse Boolean word
	        ) {
	    // 未完待续
		// 在这里我要做一个测试
		// 敬请期待
	    // 这是我写的，我想折磨写
	    // TODO 校验完以后怎么办？？？
	    // 上边依据要留下，
        return "";
	}

	//@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
	@RequestMapping(value="/indexTest")//,method=RequestMethod.POST
	public String indexTest(@PathVariable(name = "urlParam",required = true)Integer urlParam, Integer value ,ModelMap model){
		//BaseCompany company = companyService.selectByPrimaryKey(1);
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("companyCode", "com001");
		map.put("managerName", "张");
		int pageNo = 1;
		int pageSize = 5;
		PageInfo<Map<String, Object>> pageInfo = companyService.selectComManMapListPageByMap(map,pageNo,pageSize);
		logger.warn("pageInfo={}",JSON.toJSONString(pageInfo));
		if (urlParam==1) {
			
			value = 666;
		}else if (urlParam==2) {
			value = 999;
		}
		model.addAttribute("value", value);
		return "/company/indexTest";
	}
	// 添加注释
	@ResponseBody
	@RequestMapping(value="/indexTest2")//,method=RequestMethod.POST
	public List<Map<String, Object>> indexTest2(@PathVariable("urlParam")Integer urlParam,Integer value ,ModelMap model){
		//BaseCompany company = companyService.selectByPrimaryKey(1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyCode", "com001");
		//map.put("managerName", "张");
		List<Map<String, Object>> list = companyService.selectComManMapListByMap(map);
		logger.warn("list={}",JSON.toJSONString(list));
		return list;
	}
	
	//restfull风格接口示例：
	
	//（@RequestParam、 @RequestBody、 @RequestHeader 、 @PathVariable）
	//{"companyCode":"com002","firstManagerName":"","certificateCode":"","pkid":2,"regionCode":"","firstManagerTelephone":"","companyAddress":"","companyName":"企业002","groupCode":""}
	//测试路径：http://localhost:8082/shiningcity190201-maven-mybatis/1/company/receiveParam/2019-04-06/2019-04-06 12:12:12?param1=999&param2=666
	//测试Header：Content-Type=application/json；header=888
	//测试Body（postman选择raw，数据类型JSON(application/json)）：{"companyCode":"com002","firstManagerName":"","certificateCode":"","pkid":2,"regionCode":"","firstManagerTelephone":"","companyAddress":"","companyName":"企业002","groupCode":""}
	@ResponseBody
	@PostMapping(value="/postMapping/{day}/{datetime}",params={"param1","param2"})	//params={"param1","param2"}指定必须要存在这两个参数
	public Map<Object, Object> postMapping(@PathVariable Integer urlParam,@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date datetime,@RequestBody BaseCompany company,@RequestParam String param1,@RequestParam String param2,@RequestHeader String header){
		logger.warn("urlParam={}",urlParam);
		logger.warn("day={}",day);
		logger.warn("datetime={}",datetime);
		logger.warn("company={}",JSON.toJSON(company));
		logger.warn("param1={}",param1);
		logger.warn("param2={}",param2);
		logger.warn("header={}",header);
		logger.warn("testValue={}",testValue);
		logger.warn("testValue2={}",testValue2);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("urlParam", urlParam);
		map.put("day", day);
		map.put("datetime", datetime);
		map.put("company", company);
		map.put("param1", param1);
		map.put("param2", param2);
		map.put("header", header);
		return map;
	}
	
	@ResponseBody
	@GetMapping(value="/getMapping/{day}/{datetime}")
	public Map<Object, Object> getMapping(@PathVariable Integer urlParam,@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date datetime,@RequestParam String param1,@RequestParam String param2,@RequestHeader String header){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("urlParam", urlParam);
		map.put("day", day);
		map.put("datetime", datetime);
		map.put("param1", param1);
		map.put("param2", param2);
		map.put("header", header);
		return map;
	}
	
	@ResponseBody
	@PutMapping(value="/putMapping/{day}/{datetime}/{id}")
	public Map<Object, Object> putMapping(@PathVariable Integer urlParam,@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date datetime,@PathVariable Integer id,@RequestBody BaseCompany company,@RequestParam String param1,@RequestParam String param2,@RequestHeader String header){
		//可以从requestbody中接收company对象并对其修改。
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("urlParam", urlParam);
		map.put("day", day);
		map.put("datetime", datetime);
		map.put("company", company);
		map.put("param1", param1);
		map.put("param2", param2);
		map.put("header", header);
		return map;
	}

	@ResponseBody
	@PatchMapping(value="/putMapping/{day}/{datetime}/{id}")
	public Map<Object, Object> patchMapping(@PathVariable Integer urlParam,@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date datetime,@RequestBody BaseCompany company,@RequestParam String param1,@RequestParam String param2,@RequestHeader String header){
		//可以从requestbody中接收company对象并对其修改。
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("urlParam", urlParam);
		map.put("day", day);
		map.put("datetime", datetime);
		map.put("company", company);
		map.put("param1", param1);
		map.put("param2", param2);
		map.put("header", header);
		return map;
	}

	@ResponseBody
	@DeleteMapping(value="/deleteMapping/{day}/{datetime}")
	public Map<Object, Object> deleteMapping(@PathVariable Integer urlParam,@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date datetime,@RequestBody BaseCompany company,@RequestParam String param1,@RequestParam String param2,@RequestHeader String header){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("urlParam", urlParam);
		map.put("day", day);
		map.put("datetime", datetime);
		map.put("company", company);
		map.put("param1", param1);
		map.put("param2", param2);
		map.put("header", header);
		return map;
	}
	
    @ResponseBody
    @PostMapping(value="/testGetSpringBean")
    public String testGetSpringBean(){
        TestSpringContextHolder testHolder = new TestSpringContextHolder();
        testHolder.testGetSpringBean();
        return "ok";
    }
    
}