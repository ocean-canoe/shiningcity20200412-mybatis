package com.shiningcity.company.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.shiningcity.common.enums.CodeTypeEnum;

@Controller
@RequestMapping("/requestResponse")
public class RequestResponseController {
    
    // 随机字符库
    private String BASE_CHINESE_CHAR = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3\u5757\u8dd1\u8c01\u8349\u8d8a\u5b57\u52a0\u811a\u7d27\u7231\u7b49\u4e60\u9635\u6015\u6708\u9752\u534a\u706b\u6cd5\u9898\u5efa\u8d76\u4f4d\u5531\u6d77\u4e03\u5973\u4efb\u4ef6\u611f\u51c6\u5f20\u56e2\u5c4b\u79bb\u8272\u8138\u7247\u79d1\u5012\u775b\u5229\u4e16\u521a\u4e14\u7531\u9001\u5207\u661f\u5bfc\u665a\u8868\u591f\u6574\u8ba4\u54cd\u96ea\u6d41\u672a\u573a\u8be5\u5e76\u5e95\u6df1\u523b\u5e73\u4f1f\u5fd9\u63d0\u786e\u8fd1\u4eae\u8f7b\u8bb2\u519c\u53e4\u9ed1\u544a\u754c\u62c9\u540d\u5440\u571f\u6e05\u9633\u7167\u529e\u53f2\u6539\u5386\u8f6c\u753b\u9020\u5634\u6b64\u6cbb\u5317\u5fc5\u670d\u96e8\u7a7f\u5185\u8bc6\u9a8c\u4f20\u4e1a\u83dc\u722c\u7761\u5174\u5f62\u91cf\u54b1\u89c2\u82e6\u4f53\u4f17\u901a\u51b2\u5408\u7834\u53cb\u5ea6\u672f\u996d\u516c\u65c1\u623f\u6781\u5357\u67aa\u8bfb\u6c99\u5c81\u7ebf\u91ce\u575a\u7a7a\u6536\u7b97\u81f3\u653f\u57ce\u52b3\u843d\u94b1\u7279\u56f4\u5f1f\u80dc\u6559\u70ed\u5c55\u5305\u6b4c\u7c7b\u6e10\u5f3a\u6570\u4e61\u547c\u6027\u97f3\u7b54\u54e5\u9645\u65e7\u795e\u5ea7\u7ae0\u5e2e\u5566\u53d7\u7cfb\u4ee4\u8df3\u975e\u4f55\u725b\u53d6\u5165\u5cb8\u6562\u6389\u5ffd\u79cd\u88c5\u9876\u6025\u6797\u505c\u606f\u53e5\u533a\u8863\u822c\u62a5\u53f6\u538b\u6162\u53d4\u80cc\u7ec6";
    private String BASE_NUM_LETTER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String BASE_NUM = "0123456789";
    private String BASE_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /*
HttpServletRequest对象代表客户端的请求，当客户端通过HTTP协议访问服务器时，HTTP请求头中所有信息都封装在这个对象中。通过这个对象提供的方法，可以获得客户端请求的所有信息。
http://localhost:8082/shiningcity190201-maven-mybatis/requestResponse/httpServletRequest?hello=你好&hello2=你好&hello2=还是你好
     */
    @PostMapping(value="/httpServletRequest")
    public void testHttpServletRequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
//boolean authenticate = request.authenticate(response);

response.setCharacterEncoding("utf-8"); // 告诉servlet使用utf-8编码字符流，而不是默认的iso8859，否则会出现“？？”乱码。
response.setHeader("content-type", "text/html;charset=utf-8"); // 告诉浏览器使用utf-解码，否则会出现“烇湫”乱码。

PrintWriter writer = response.getWriter();  // 使用字符流输出
writer.write("这样也可以\r\n");
writer.write("这样也可以\r\n");
writer.write("这样也可以\r\n");
writer.write("这样也可以\r\n");

// 获取服务器、客户机信息
writer.println("request.getRequestURL()："+request.getRequestURL());// 得到请求的URL地址
writer.println("request.getRequestURI()："+request.getRequestURI());// 得到请求的资源
writer.println("request.getQueryString()："+request.getQueryString());// 得到请求的URL地址中附带的参数
writer.println("request.getRemoteAddr()："+request.getRemoteAddr());// 得到来访者的IP地址
writer.println("request.getRemoteHost()："+request.getRemoteHost());
writer.println("request.getRemotePort()："+request.getRemotePort());
writer.println("request.getRemoteUser()："+request.getRemoteUser());
writer.println("request.getMethod()："+request.getMethod());// 获得请求url地址时使用的请求方式（GET、POST）
writer.println("request.getPathInfo()："+request.getPathInfo());
writer.println("request.getLocalAddr()："+request.getLocalAddr());// 获取服务器的ip地址
writer.println("request.getLocalName()："+request.getLocalName());// 获取服务器的主机名

// 获取客户端请求头
Enumeration<String> headerNames = request.getHeaderNames();
//writer.println("request.getHeaderNames()："+JSON.toJSONString(headerNames));// 使用json输出headerNames时会用到headerNames.nextElement()，所以后边在循环遍历时headerNames.hasMoreElements()==false
while (headerNames.hasMoreElements()) {
    String headerName = (String) headerNames.nextElement();
    writer.println("Header--"+headerName+"："+request.getHeader(headerName));
}

// 获取客户机请求参数
request.setCharacterEncoding("utf-8");// 以utf-8编码格式接收post请求参数
String hello = request.getParameter("hello");
writer.println("request.getParameter(\"hello\")："+hello);// 接收get请求参数
writer.println("request.getParameter(\"hello\")："+request.getParameter("hello"));// 接收get请求参数
writer.println("request.getParameter(\"hello2\")："+request.getParameter("hello2")); // 接收get请求参数，
writer.println("request.getParameter(\"world\")："+request.getParameter("world"));// 接收post请求参数
writer.println("request.getParameter(\"world2\")："+request.getParameter("world2")); // 接收post请求参数，
writer.println("request.getParameterValues(\"hello2\")："+JSON.toJSONString(request.getParameterValues("hello2")));
writer.println("request.getParameterValues(\"world2\")："+JSON.toJSONString(request.getParameterValues("world2")));
writer.println("request.getParameterMap()："+JSON.toJSONString(request.getParameterMap()));
writer.println("request.getParameterNames()："+JSON.toJSONString(request.getParameterNames()));
// 接收完get请求参数以后，将iso8859-1编码格式转换称utf-8编码格式
writer.println("request.getParameter(\"hello\")："+new String(hello.getBytes("ISO8859-1"),"utf-8"));

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    e.printStackTrace();
}

// 获取session
HttpSession session = request.getSession();
session.setMaxInactiveInterval(3600); //单位：秒。
session.setAttribute("HelloWorld", "HelloWorld");
String HelloWorld = (String) session.getAttribute("HelloWorld");
writer.println("sessionid："+session.getId());
writer.println("session："+JSON.toJSONString(session));
writer.println("session.getServletContext().getContextPath()："+session.getServletContext().getContextPath());
writer.println("session.getServletContext().getRealPath(\"//\")"+session.getServletContext().getRealPath("//"));
writer.println("session.getServletContext().getRealPath(\"/\")"+session.getServletContext().getRealPath("/"));
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
Date creationTime = new Date(session.getCreationTime());
Date lastAccessedTime = new Date(session.getLastAccessedTime());
writer.println("session.getCreationTime()："+format.format(creationTime));   // session创建时间
writer.println("session.getLastAccessedTime()："+format.format(lastAccessedTime));//最后一次访问时间
writer.println("session.getAttribute(\"HelloWorld\")："+HelloWorld);
// postman测试时会自己携带cookie，前端请求时需要在header中设置cookie：JSESSIONID=674FFF35D19E3782362C0AE6CE743E84才能包拯session不变

    }
    
//这样也可以
//这样也可以
//这样也可以
//这样也可以
//request.getRequestURL()：http://localhost:8082/shiningcity190201-maven-mybatis/requestResponse/httpServletRequest
//request.getRequestURI()：/shiningcity190201-maven-mybatis/requestResponse/httpServletRequest
//request.getQueryString()：hello=%E4%BD%A0%E5%A5%BD&hello2=%E4%BD%A0%E5%A5%BD&hello2=%E8%BF%98%E6%98%AF%E4%BD%A0%E5%A5%BD
//request.getRemoteAddr()：0:0:0:0:0:0:0:1
//request.getRemoteHost()：0:0:0:0:0:0:0:1
//request.getRemotePort()：51135
//request.getRemoteUser()：null
//request.getMethod()：POST
//request.getPathInfo()：null
//request.getLocalAddr()：0:0:0:0:0:0:0:1
//request.getLocalName()：0:0:0:0:0:0:0:1
//Header--cache-control：no-cache
//Header--postman-token：3415f234-0f76-44e2-aa27-58313c389548
//Header--user-agent：PostmanRuntime/7.6.0
//Header--accept：*/*
//Header--host：localhost:8082
//Header--cookie：JSESSIONID=674FFF35D19E3782362C0AE6CE743E84
//Header--accept-encoding：gzip, deflate
//Header--content-type：multipart/form-data; boundary=--------------------------474480030811266274425173
//Header--content-length：394
//Header--connection：keep-alive
//request.getParameter("hello")：ä½ å¥½
//request.getParameter("hello")：ä½ å¥½
//request.getParameter("hello2")：ä½ å¥½
//request.getParameter("world")：世界
//request.getParameter("world2")：世界
//request.getParameterValues("hello2")：["ä½ å¥½","è¿\u0098æ\u0098¯ä½ å¥½"]
//request.getParameterValues("world2")：["世界","还是世界"]
//request.getParameterMap()：{"hello":["ä½ å¥½"],"hello2":["ä½ å¥½","è¿\u0098æ\u0098¯ä½ å¥½"],"world2":["世界","还是世界"],"world":["世界"]}
//request.getParameterNames()：["hello","hello2","world2","world"]
//request.getParameter("hello")：你好
//sessionid：674FFF35D19E3782362C0AE6CE743E84
//session：{"attributeNames":["HelloWorld"],"creationTime":1578559768472,"id":"674FFF35D19E3782362C0AE6CE743E84","lastAccessedTime":1578559768472,"maxInactiveInterval":3600,"new":true,"servletContext":{"attributeNames":["javax.servlet.context.tempdir","org.apache.catalina.resources","org.springframework.web.context.support.ServletContextScope","org.springframework.web.context.WebApplicationContext.ROOT","org.apache.tomcat.util.scan.MergedWebXml","org.apache.tomcat.InstanceManager","org.springframework.web.servlet.FrameworkServlet.CONTEXT.springmvc","org.apache.catalina.jsp_classpath","javax.websocket.server.ServerContainer","org.apache.jasper.compiler.TldLocationsCache","org.apache.tomcat.JarScanner"],"contextPath":"/shiningcity190201-maven-mybatis","defaultSessionTrackingModes":["COOKIE","URL"],"effectiveMajorVersion":3,"effectiveMinorVersion":0,"effectiveSessionTrackingModes":["COOKIE","URL"],"filterRegistrations":{"org.apache.tomcat.websocket.server.WsFilter":{"className":"org.apache.tomcat.websocket.server.WsFilter","initParameters":{},"name":"org.apache.tomcat.websocket.server.WsFilter","servletNameMappings":[],"urlPatternMappings":["/*"]},"CharacterEncodingFilter":{"className":"org.springframework.web.filter.CharacterEncodingFilter","initParameters":{"encoding":"utf-8"},"name":"CharacterEncodingFilter","servletNameMappings":[],"urlPatternMappings":["/*"]}},"initParameterNames":["contextConfigLocation"],"majorVersion":3,"minorVersion":0,"serverInfo":"Apache Tomcat/7.0.47","servletNames":[],"servletRegistrations":{"default":{"className":"org.apache.catalina.servlets.DefaultServlet","initParameters":{"listings":"false","debug":"0"},"mappings":[],"name":"default"},"jsp":{"className":"org.apache.jasper.servlet.JspServlet","initParameters":{"fork":"false","xpoweredBy":"false"},"mappings":["*.jspx","*.jsp"],"name":"jsp"},"springmvc":{"className":"org.springframework.web.servlet.DispatcherServlet","initParameters":{"contextConfigLocation":"classpath:spring/springmvc.xml"},"mappings":["/"],"name":"springmvc"}},"servlets":[],"sessionCookieConfig":{"httpOnly":false,"maxAge":-1,"secure":false}},"sessionContext":{"ids":[]},"valueNames":["HelloWorld"]}
//session.getServletContext().getContextPath()：/shiningcity190201-maven-mybatis
//session.getServletContext().getRealPath("//")D:\EclipseWorkSpace\workspace03\shiningcity190201-maven-mybatis\src\main\webapp
//session.getServletContext().getRealPath("/")D:\EclipseWorkSpace\workspace03\shiningcity190201-maven-mybatis\src\main\webapp\
//session.getCreationTime()：2020-01-09 16:49:28 472
//session.getLastAccessedTime()：2020-01-09 16:49:28 472
//session.getAttribute("HelloWorld")：HelloWorld
    
    // 使用字节流输出文本
    @PostMapping(value="/httpServletResponseString")
    public void httpServletResponseString(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //response.setCharacterEncoding("utf-8"); // 告诉servlet使用utf-8编码字符流。对于字节流不起作用。
        response.setHeader("content-type", "text/html;charset=utf-8");  // 告诉浏览器使用utf-8解码
        
        // 设置浏览器不缓存数据
        //response.setHeader("expries", "-1");
        response.setDateHeader("expries", -1);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");//浏览器和缓存server都不应该缓存页面信息
        //response.addHeader("Cache-Control", "no-store");//请求和响应的信息都不应该被存储在对方的磁盘   
        //response.addHeader("Cache-Control", "must-revalidate");//于客户机的每次请求，代理server必须想server验证缓存是否过时。
        
//        // 设置浏览器缓存数据
//        //response.setHeader("expries", new Date().getTime()+24*60*60+"");
//        response.setDateHeader("expries", new Date().getTime()+24*60*60); // 缓存1天
//        response.setHeader("Pragma", "Pragma"); //Pragma:设置页面是否缓存，为Pragma则缓存，no-cache则不缓存
//        response.setHeader("Cache-Control", "public");// public:浏览器和缓存server都能够缓存页面信息
        
        // 注意使用字节流以后不能再使用字符流，使用字符流以后不能再使用字节流。
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("这样也可以\r\n".getBytes("utf-8"));  // 使用utf-8格式获取字节流。
        outputStream.write("这样也可以\r\n".getBytes("utf-8"));
        outputStream.write("这样也可以\r\n".getBytes("utf-8"));
        outputStream.write("这样也可以\r\n".getBytes("utf-8"));
        outputStream.write("1".getBytes("utf-8"));   // 如果想输出数字，请将数字转成字符串再获取字节流。
        outputStream.write(1);  // 这样将无法输出数字。
        outputStream.close();
    }
    
    // 使用字节流下载文件
    @PostMapping(value="/httpServletResponseFile")
    public void httpServletResponseFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // pdf文档
        String filename = "中文名称.pdf";
        response.setContentType("application/pdf"); // 这样可以
        //response.setContentType("application/x-download"); // 这样也可以
        //response.setHeader("Content-Type", "application/pdf"); // 这样也可以
        response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(filename, "UTF-8"));// 这样可以
        //response.setHeader("Content-Disposition", "attachment;fileName="+new String(filename.getBytes("GB2312"),"ISO-8859-1"));// 这样也可以
        //response.setHeader("Content-Disposition", "attachment;fileName="+new String(filename.getBytes("GBK"),"ISO-8859-1"));// 这样也可以
        //response.setHeader("Content-Disposition", "attachment;fileName="+new String(filename.getBytes(),"ISO-8859-1"));// 这样也可以
        // attachment：浏览器将提示下载文件；inline：浏览器将尝试直接打开文件，如果浏览器无法直接打开将提示下载。
        //response.setHeader("Content-Disposition", "inline;fileName="+URLEncoder.encode(filename, "utf-8"));// 浏览器将直接打开文件
        
//        // word文档
//        String filename = "中文名称.docx";
//        response.setContentType("application/msword");
//        //response.setContentType("application/x-download");
//        //response.setHeader("Content-Type", "application/msword");
//        response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(filename, "UTF-8"));
//        //response.setHeader("Content-Disposition", "attachment;fileName="+new String(filename.getBytes(),"ISO-8859-1"));
//        //response.setHeader("Content-Disposition", "inline;fileName="+URLEncoder.encode(filename, "utf-8"));
        
        // 文件输入字节流
        File file = new File("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.pdf");
        //File file = new File("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.docx");
        FileInputStream inputStream = new FileInputStream(file);
        // 用于读取文件的byte数组
        byte[] bytes = new byte[8192];
        // response的输出字节流
        ServletOutputStream outputStream = response.getOutputStream();
        // 每次读取长度
        int len = 0;
        // 读取文件字节，输出到输出字节流
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes,0,len);
        }
        
        // 关闭
        outputStream.close();
        inputStream.close();
    }
    
    // 使用字节流生成验证码
    @GetMapping(value="/httpServletResponseCode")
    public void httpServletResponseCode(String codeType,HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 在内存中创建一张图片
        BufferedImage image = new BufferedImage(120, 30, BufferedImage.TYPE_INT_RGB);
        // 设置图片背景
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 120, 30);
        // 设置边框
        graphics.setColor(Color.GREEN);
        graphics.drawRect(1, 1, 118, 28);
        // 设置干扰线
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 5; i++) {
            int x1 = new Random().nextInt(30);
            int x2 = new Random().nextInt(30);
            int y1 = new Random().nextInt(120);
            int y2 = new Random().nextInt(120);
            graphics.drawLine(x1, y1, x2, y2);
        }
        // 设置图片上的验证码
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        //graphics.drawString(makeNum(), 0, 20);
        String random = drawRandomNum(graphics, codeType);
        // 将验证码存入session
        request.getSession().setAttribute("checkcode", random);
        // 设置response
        response.setHeader("refresh", "5");// 设置浏览器每5秒中刷新一次。
        response.setHeader("Content-Type", "image/jpeg");//设置浏览器以图片的方式打开数据
        // 设置浏览器不缓存图片
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        // 将图片写给浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
    
    // 生成6位随机数字
    private String makeNum() {
        Random random = new Random();
        int nextInt = random.nextInt(999999);
        if (nextInt<100000) {
            nextInt += 100000;
        }
        return String.valueOf(nextInt);
    }
    
    // 生成随机字符
    private String drawRandomNum(Graphics2D g,String codeTypeString) {
        CodeTypeEnum codeTypeEnum = CodeTypeEnum.getByCode(codeTypeString);
        g.setColor(Color.BLUE);
        g.setFont(new Font("宋体", Font.BOLD, 20));
        if (null != codeTypeEnum) {
            switch (codeTypeEnum) {
                case CODE_TYPE_CHINESE:
                    return createRandomChar(g, BASE_CHINESE_CHAR);
                case CODE_TYPE_NUMLETTER:
                    return createRandomChar(g, BASE_NUM_LETTER);
                case CODE_TYPE_NUM:
                    return createRandomChar(g, BASE_NUM);
                case CODE_TYPE_LETTER:
                    return createRandomChar(g, BASE_LETTER);
            }
        }
        // 默认生成数字加字母的验证码
        return createRandomChar(g, BASE_NUM_LETTER);
    }
    
    // 创建随机字符
    private String createRandomChar(Graphics2D g,String baseChar) {
        StringBuffer sb = new StringBuffer();
        String ch = null;
        int x = 0;
        for (int i = 0; i < 4; i++) {
            // 字体旋转角度
            int degree = new Random().nextInt() % 30;
            // 随机字符
            ch = String.valueOf(baseChar.charAt(new Random().nextInt(baseChar.length())));
            sb.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI / 180,x,20);
            g.drawString(ch, x, 20);
            // 反向角度
            g.rotate(-degree * Math.PI / 180,x,20);
            x += 30;
        }
        return sb.toString();
    }
    
}

/*
本文主要讲述response乱码原因及 response.setCharacterEncoding("UTF-8")不生效的原因及解决方法

一、response乱码

1、首先，response返回有两种，一种是字节流outputstream，一种是字符流printwrite。

申明：这里为了方便起见，所有输出都统一用UTF-8编码。

先说字节流，要输出“中国"，给输出流的必须是转换为utf-8的“中国”,还要告诉浏览器，用utf8来解析数据




//这句话的意思，是让浏览器用utf8来解析返回的数据  
        response.setHeader("Content-type", "text/html;charset=UTF-8");  
        String data = "中国";  
        OutputStream ps = response.getOutputStream();  
        //这句话的意思，使得放入流的数据是utf8格式  
        ps.write(data.getBytes("UTF-8"));  
    2、再说字符流，要输出中国，需要设置response.setCharacterEncoding("UTF-8");

//这句话的意思，是让浏览器用utf8来解析返回的数据  
response.setHeader("Content-type", "text/html;charset=UTF-8");  
//这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859  
response.setCharacterEncoding("UTF-8");  
String data = "中国";  
PrintWriter pw = response.getWriter();  
pw.write(data);  


经验：1，如果中文返回出现？？字符，这表明没有加response.setCharacterEncoding("UTF-8");这句话。

2，如果返回的中文是“烇湫”这种乱码，说明浏览器的解析问题，应该检查下是否忘加response.setHeader("Content-type", "text/html;charset=UTF-8");这句话。

 */
