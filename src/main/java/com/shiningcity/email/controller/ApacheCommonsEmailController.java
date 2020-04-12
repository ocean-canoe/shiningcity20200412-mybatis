package com.shiningcity.email.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.mail.MessagingException;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceCompositeResolver;
import org.apache.commons.mail.resolver.DataSourceFileResolver;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiningcity.common.pojo.BaseResponse;

/**
 * 使用JavaMail发送邮件。
 * 发送速度太慢，应该使用单独的线程发送。
 * 应该有重发机制，因为有时会发送失败，更多原因是连接超时。
 * @Author dikaihui
 * @Date 2020年1月12日
 */
@Controller
@RequestMapping("/commonsEmail")
public class ApacheCommonsEmailController {
    
    private String HOST = "smtp.126.com";
    private String SENDER = "shiningcity@126.com";
    private String RECIPIENT = "dikaihui@126.com";
    private String COPYTO = "dikaihui@163.com";
    private String PASSWORD = "";
    
    /**
     * 使用CommonsEmail发送文本邮件
     * qq邮箱没有开启pop3/smtp服务，所以不能使用。
     * @throws EmailException 
     */
    @ResponseBody
    @PostMapping("/sendTextEmail")
    public BaseResponse<Object> sendTextEmail(String sender,String recipient,String copyTo,String password,Integer mailType) throws MessagingException, FileNotFoundException, IOException, EmailException {
        String host = HOST;
        sender = SENDER;
        recipient = RECIPIENT;
        copyTo = COPYTO;
        password = PASSWORD;
        
        SimpleEmail email = new SimpleEmail();
        email.setHostName(host);
        //email.setSmtpPort(465);// 25?  456?
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setSSLOnConnect(true);
        email.setCharset("UTF-8");
        email.setFrom(sender);
        email.addTo(recipient);// 可输入多个收件人
        email.addCc(copyTo);// 可输入多个抄送人
        email.setSubject("这是邮件标题");
        email.setMsg("这是邮件内容。。。。。。");
        String message = email.send();
        
        return new BaseResponse<>(true,message);
    }

    /**
     * 使用CommonsEmail发送附件邮件
     * @throws EmailException 
     */
    @ResponseBody
    @PostMapping("/sendMultPartEmail")
    public BaseResponse<Object> sendMultPartEmail(String sender,String recipient,String copyTo,String password,Integer mailType) throws MessagingException, FileNotFoundException, IOException, EmailException {
        String host = HOST;
        sender = SENDER;
        recipient = RECIPIENT;
        copyTo = COPYTO;
        password = PASSWORD;
        
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12.jpg");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("this is a picture named 2020-01-12");
        attachment.setName("2020-01-12.jpg");

        EmailAttachment attachment2 = new EmailAttachment();
        attachment2.setPath("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.pdf");
        attachment2.setDisposition(EmailAttachment.ATTACHMENT);
        attachment2.setDescription("this is a picture named 中文名称pdf");
        attachment2.setName("中文名称pdf.pdf");
        
        EmailAttachment attachment3 = new EmailAttachment();
        attachment3.setPath("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.docx");
        attachment3.setDisposition(EmailAttachment.ATTACHMENT);
        attachment3.setDescription("this is a picture named 中文名称word");
        attachment3.setName("中文名称word.docx");
        
        EmailAttachment attachment4 = new EmailAttachment();
        attachment4.setPath("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\file.rar");
        attachment4.setDisposition(EmailAttachment.ATTACHMENT);
        attachment4.setDescription("this is a picture named filerar");
        attachment4.setName("filerar.rar");
        
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(host);
        //email.setSmtpPort(465);// 25?  456?
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setSSLOnConnect(true);
        email.setCharset("UTF-8");
        email.setFrom(sender);
        email.addTo(recipient);// 可输入多个收件人
        email.addCc(copyTo);// 可输入多个抄送人
        email.setSubject("这是邮件标题");
        email.setMsg("这是邮件内容。。。。。。");
        email.attach(attachment);   // 添加附件
        email.attach(attachment2);  // 添加附件
        email.attach(attachment3);  // 添加附件
        email.attach(attachment4);  // 添加附件
        String message = email.send();
        
        return new BaseResponse<>(true,message);
    }

    /**
     * 使用CommonsEmail发送网络附件邮件
     * @throws EmailException 
     */
    @ResponseBody
    @PostMapping("/sendNetMultPartEmail")
    public BaseResponse<Object> sendNetMultPartEmail(String sender,String recipient,String copyTo,String password,Integer mailType) throws MessagingException, FileNotFoundException, IOException, EmailException {
        String host = HOST;
        sender = SENDER;
        recipient = RECIPIENT;
        copyTo = COPYTO;
        password = PASSWORD;
        
        EmailAttachment attachment = new EmailAttachment();
        attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("this is a picture named Apache logo");
        attachment.setName("Apache logo.gif");

        EmailAttachment attachment2 = new EmailAttachment();
        attachment2.setPath("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.pdf");
        attachment2.setDisposition(EmailAttachment.ATTACHMENT);
        attachment2.setDescription("this is a picture named 中文名称");
        attachment2.setName("中文名称pdf.pdf");

        EmailAttachment attachment3 = new EmailAttachment();
        attachment3.setPath("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.docx");
        attachment3.setDisposition(EmailAttachment.ATTACHMENT);
        attachment3.setDescription("this is a picture named 中文名称word");
        attachment3.setName("中文名称word.docx");

        EmailAttachment attachment4 = new EmailAttachment();
        attachment4.setPath("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12.jpg");
        attachment4.setDisposition(EmailAttachment.ATTACHMENT);
        attachment4.setDescription("this is a picture named 2020-01-12");
        attachment4.setName("2020-01-12.jpg");

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(host);
        //email.setSmtpPort(465);// 25?  456?
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setSSLOnConnect(true);
        email.setCharset("UTF-8");
        email.setFrom(sender);
        email.addTo(recipient);// 可输入多个收件人
        email.addCc(copyTo);// 可输入多个抄送人
        email.setSubject("这是邮件标题");
        email.setMsg("这是邮件内容。。。。。。");
        email.attach(attachment);   // 添加附件
        email.attach(attachment2);  // 添加附件
        email.attach(attachment3);  // 添加附件
        email.attach(attachment4);  // 添加附件
        String message = email.send();
        
        return new BaseResponse<>(true,message);
    }

    /**
     * 使用CommonsEmail发送HTML格式邮件
     * @throws EmailException 
     */
    @ResponseBody
    @PostMapping("/sendHtmlEmail")
    public BaseResponse<Object> sendHtmlEmail(String sender,String recipient,String copyTo,String password,Integer mailType) throws MessagingException, FileNotFoundException, IOException, EmailException {
        String host = HOST;
        sender = SENDER;
        recipient = RECIPIENT;
        copyTo = COPYTO;
        password = PASSWORD;
        
        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        //email.setSmtpPort(465);// 25?  456?
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setSSLOnConnect(true);
        email.setCharset("UTF-8");
        email.setFrom(sender);
        email.addTo(recipient);// 可输入多个收件人
        email.addCc(copyTo);// 可输入多个抄送人
        email.setSubject("这是邮件标题");
        email.setMsg("这是邮件内容。。。。。。");// 无法显示
        
        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
        String cid = email.embed(url, "Apache logo");
        email.setHtmlMsg("<html>This is apache logo - <img src=\"cid:"+cid+"\"></html>");
        //如果客户端不去持HTML格式会显示这句话，不过应该很少有不支持HTML格式的客户端了吧
        email.setTextMsg("你的邮箱客户端不支持HTML格式邮件");
        
        String message = email.send();
        
        return new BaseResponse<>(true,message);
    }

    /**
     * 使用CommonsEmail发送带图片的HTML格式邮件
     * 报错：com.sun.mail.smtp.SMTPSendFailedException: 554 DT:SPM 126 smtp9,NeRpCgBHWNowKB1et5sWAg--
     * 是因为被当成垃圾邮件了。
     * @throws EmailException 
     */
    @ResponseBody
    @PostMapping("/sendImageHtmlEmail")
    public BaseResponse<Object> sendImageHtmlEmail(String sender,String recipient,String copyTo,String password,Integer mailType) throws MessagingException, FileNotFoundException, IOException, EmailException {
        String host = HOST;
        sender = SENDER;
        recipient = RECIPIENT;
        copyTo = COPYTO;
        password = PASSWORD;
        
        ImageHtmlEmail email = new ImageHtmlEmail();
        email.setHostName(host);
        //email.setSmtpPort(465);// 25?  456?
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setSSLOnConnect(true);
        email.setCharset("UTF-8");
        email.setFrom(sender);
        email.addTo(recipient);// 可输入多个收件人
        email.addCc(copyTo,sender);// 可输入多个抄送人
        email.setSubject("这是邮件标题");
        email.setMsg("这是邮件内容。。。。。。");
        
        //解析本地图片和网络图片都有的html文件重点就是下面这两行；
        //ImageHtmlEmail通过setDataSourceResolver来识别并嵌入图片
        //查看DataSourceResolver的继承结构发现有几个好用的子类
        DataSourceResolver[] dataSourceResolvers = new DataSourceResolver[]{
            //添加DataSourceFileResolver用于解析本地图片
            new DataSourceFileResolver(new File("D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12.jpg")),
            //添加DataSourceUrlResolver用于解析网络图片，
            new DataSourceUrlResolver(new URL("http://www.apache.org"))};
        //DataSourceCompositeResolver类可以加入多个DataSourceResolver,
        //把需要的DataSourceResolver放到一个数组里传进去就可以了；
        email.setDataSourceResolver(new DataSourceCompositeResolver(dataSourceResolvers));

        String htmlEmailContent = "这是一张用于测试的图片，<img src=\"http://commons.apache.org/proper/commons-email/images/commons-logo.png\">";
        email.setHtmlMsg(htmlEmailContent);
        //如果客户端不去持HTML格式会显示这句话，不过应该很少有不支持HTML格式的客户端了吧
        email.setTextMsg("你的邮箱客户端不支持HTML格式邮件");
        
        String message = email.send();
        
        return new BaseResponse<>(true,message);
    }
    
    
}
