package com.shiningcity.email.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.aspectj.bridge.MessageWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用JavaMail发送邮件
 * 发送速度太慢，应该使用单独的线程发送。
 * 应该有重发机制，因为有时会发送失败，更多原因是连接超时。
 * @Author dikaihui
 * @Date 2020年1月12日
 */
@Controller
@RequestMapping("/javaMail")
public class JavaMailController {
    
    /**
     * 使用JavaMail发送邮件
     * qq邮箱没有开启pop3/smtp服务，所以不能使用。
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    @ResponseBody
    @PostMapping("/sendEmail126")
    public boolean sendEmail126(String sender,String recipient,String copyTo,String password,Integer mailType) throws MessagingException, FileNotFoundException, IOException {
        sender = "shiningcity@126.com";
        recipient = "dikaihui@126.com";
        copyTo = "dikaihui@163.com";
        password = "";
        //mailType = 1;
        // 设置属性
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.126.com");
        // 25?  465?
        //prop.setProperty("mail.smtp.port", "25");// 此属性可以不设置
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");   // 添加验证的话有时邮件会被判定为垃圾邮件而发送失败
        prop.setProperty("mail.smtp.ssl.enable", "true");
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.fallback", "true");
        prop.setProperty("mail.from", sender);
        prop.setProperty("mail.user", recipient);
        // 使用JavaMail发送邮件的5个步骤。
        // 1、创建邮件session
        Session session = Session.getInstance(prop);
        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        //session.setDebug(true);   // 开启以后日志比较多，附件的流也会被打印日志。
        // 2、通过session得到transport对象
        Transport transport = session.getTransport();
        String host = "smtp.126.com";
        // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        //transport.connect(host, 25, sender, password);// 此处不必带着端口号。
        transport.connect(host, sender, password);// 此处不必带着端口号。
        // 4、创建邮件
        //MimeMessage message = createSimpleMail(session, sender, recipient, copyTo);
        //MimeMessage message = createImageMail(session, sender, recipient, copyTo);
        //MimeMessage message = createAttachMail(session, sender, recipient, copyTo);
        //MimeMessage message = createMixedMail(session, sender, recipient, copyTo);
        MimeMessage message = null;
        switch (mailType) {
        case 1:
            message = createSimpleMail(session, sender, recipient, copyTo);
            break;
        case 2:
            message = createImageMail(session, sender, recipient, copyTo);
            break;
        case 3:
            message = createAttachMail(session, sender, recipient, copyTo);
            break;
        case 4:
            message = createMixedMail(session, sender, recipient, copyTo);
            break;
        case 5:
            message = createNetPartMail(session, sender, recipient, copyTo);
            break;
        case 6:
            message = createHtmlMail(session, sender, recipient, copyTo);
            break;
        }
        // 5、发送邮件
        if (message != null) {
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        }
        return false;
    }
    
    // 创建文本邮件
    public MimeMessage createSimpleMail(Session session,String sender,String recipient,String copyTo) throws AddressException, MessagingException, FileNotFoundException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));// 发件人地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));// 收件人地址（可使用数组）
        message.setRecipient(Message.RecipientType.CC, new InternetAddress(copyTo));// 抄送人地址（可使用数组）
        message.setSubject("这是邮件的标题","UTF-8");// 标题
        message.setContent("这是邮件的内容","text/html;charset=UTF-8");// 内容
        Date date = new Date();
        message.writeTo(new FileOutputStream("E:\\JavaMailData\\textMail-"+date.getTime()+".eml"));
        return message;
    }
    
    // 创建图片邮件
    public MimeMessage createImageMail(Session session,String sender,String recipient,String copyTo) throws AddressException, MessagingException, FileNotFoundException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setRecipient(Message.RecipientType.CC, new InternetAddress(copyTo));
        message.setSubject("这是邮件的标题","UTF-8");
        
        // 邮件正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封带图片的邮件：", "text/html;charset=UTF-8");
        // 邮件图片
        MimeBodyPart image = new MimeBodyPart();
        String path = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12.jpg";
        DataHandler dataHandler = new DataHandler(new FileDataSource(path));
        image.setDataHandler(dataHandler);
        image.setContentID("2020-01-12.jpg");
        // 邮件图片
        MimeBodyPart image2 = new MimeBodyPart();
        String path2 = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12-2.jpg";
        DataHandler dataHandler2 = new DataHandler(new FileDataSource(path2));
        image2.setDataHandler(dataHandler2);
        image2.setContentID("2020-01-12-2.jpg");
        // 描述数据关系
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.addBodyPart(image2);
        mimeMultipart.setSubType("related");
        /*
Multipart/mixed:表示消息体中的内容是混合组合类型，可以是文本，声音和附件等不同邮件内容的混合体。
Multipart/related:表示消息体中的内容是关联（依赖）组合类型，表示消息体中的某些内容，依赖另外的资源。
Multipart/alternative:选择组合类型。
         */
        
        message.setContent(mimeMultipart);// 邮件内容
        message.saveChanges();
        Date date = new Date();
        message.writeTo(new FileOutputStream("E:\\JavaMailData\\ImageMail-"+date.getTime()+".eml"));
        return message;
    }
    
    // 创建包含附件的邮件
    public MimeMessage createAttachMail(Session session,String sender,String recipient,String copyTo) throws AddressException, MessagingException, FileNotFoundException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setRecipient(Message.RecipientType.CC, new InternetAddress(copyTo));
        message.setSubject("这是邮件的标题","UTF-8");

        // 邮件正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("使用JavaMail创建的带附件的邮件","text/html;charset=UTF-8");
        // 邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        String path = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.pdf";
        DataHandler dataHandler = new DataHandler(new FileDataSource(path));
        attach.setDataHandler(dataHandler);
        attach.setFileName(dataHandler.getName());
        MimeBodyPart attach2 = new MimeBodyPart();
        String path2 = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称-2.pdf";
        DataHandler dataHandler2 = new DataHandler(new FileDataSource(path2));
        attach2.setDataHandler(dataHandler2);
        attach2.setFileName(dataHandler2.getName());
        // 创建容器描述数据关系
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(attach);
        mimeMultipart.addBodyPart(attach2);
        mimeMultipart.setSubType("mixed");
        /*
Multipart/mixed:表示消息体中的内容是混合组合类型，可以是文本，声音和附件等不同邮件内容的混合体。
Multipart/related:表示消息体中的内容是关联（依赖）组合类型，表示消息体中的某些内容，依赖另外的资源。
Multipart/alternative:选择组合类型。
         */
        
        message.setContent(mimeMultipart);// 邮件内容
        message.saveChanges();
        Date date = new Date();
        message.writeTo(new FileOutputStream("E:\\JavaMailData\\AttachMail-"+date.getTime()+".eml"));
        return message;
    }
    
    // 创建包含图片和附件的邮件
    public MimeMessage createMixedMail(Session session,String sender,String recipient,String copyTo) throws AddressException, MessagingException, FileNotFoundException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setRecipient(Message.RecipientType.CC, new InternetAddress(copyTo));
        message.setSubject("这是邮件的标题","UTF-8");

        // 邮件正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("使用JavaMail创建的带图片和附件的邮件","text/html;charset=UTF-8");
        // 邮件图片
        MimeBodyPart image = new MimeBodyPart();
        String imagePath = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12.jpg";
        image.setDataHandler(new DataHandler(new FileDataSource(imagePath)));
        image.setContentID("2020-01-12.jpg");
        // 邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        String path = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.pdf";
        DataHandler dataHandler = new DataHandler(new FileDataSource(path));
        attach.setDataHandler(dataHandler);
        attach.setFileName(dataHandler.getName());
        // 邮件附件2
        MimeBodyPart attach2 = new MimeBodyPart();
        String path2 = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.docx";
        DataHandler dataHandler2 = new DataHandler(new FileDataSource(path2));
        attach2.setDataHandler(dataHandler2);
        attach2.setFileName(dataHandler2.getName());
        // 邮件附件3
        MimeBodyPart attach3 = new MimeBodyPart();
        String path3 = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\file.rar";
        DataHandler dataHandler3 = new DataHandler(new FileDataSource(path3));
        attach3.setDataHandler(dataHandler3);
        attach3.setFileName(dataHandler3.getName());
        // 描述数据关系：正文和图片
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");
        // 正文和图片重新生成bodypart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mimeMultipart);
        // 描述数据关系：附件
        MimeMultipart mimeMultipart2 = new MimeMultipart();
        mimeMultipart2.addBodyPart(attach);
        mimeMultipart2.addBodyPart(attach2);
        mimeMultipart2.addBodyPart(attach3);
        // 附件与正文组合
        mimeMultipart2.addBodyPart(content);
        mimeMultipart2.setSubType("mixed");
        /*
Multipart/mixed:表示消息体中的内容是混合组合类型，可以是文本，声音和附件等不同邮件内容的混合体。
Multipart/related:表示消息体中的内容是关联（依赖）组合类型，表示消息体中的某些内容，依赖另外的资源。
Multipart/alternative:选择组合类型。
         */
        
        message.setContent(mimeMultipart2);// 邮件内容
        message.saveChanges();
        Date date = new Date();
        message.writeTo(new FileOutputStream("E:\\JavaMailData\\MixedMail-"+date.getTime()+".eml"));
        return message;
    }

    // 创建包含网络图片和附件的邮件
    public MimeMessage createNetPartMail(Session session,String sender,String recipient,String copyTo) throws AddressException, MessagingException, FileNotFoundException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setRecipient(Message.RecipientType.CC, new InternetAddress(copyTo));
        message.setSubject("这是邮件的标题","UTF-8");

        // 邮件正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("使用JavaMail创建的带图片和附件的邮件","text/html;charset=UTF-8");
        // 邮件图片
        MimeBodyPart image = new MimeBodyPart();
        String imagePath = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12.jpg";
        image.setDataHandler(new DataHandler(new FileDataSource(imagePath)));
        image.setContentID("2020-01-12.jpg");
        // 邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        String path = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.pdf";
        DataHandler dataHandler = new DataHandler(new FileDataSource(path));
        attach.setDataHandler(dataHandler);
        attach.setFileName(dataHandler.getName());
        // 邮件附件2
        MimeBodyPart attach2 = new MimeBodyPart();
        String path2 = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\中文名称.docx";
        DataHandler dataHandler2 = new DataHandler(new FileDataSource(path2));
        attach2.setDataHandler(dataHandler2);
        attach2.setFileName(dataHandler2.getName());
        // 网络图片
        MimeBodyPart attach3 = new MimeBodyPart();
        DataHandler dataHandler3 = new DataHandler(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
        attach3.setDataHandler(dataHandler3);
        attach3.setFileName(dataHandler3.getName());
        // 描述数据关系：正文和图片
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");
        // 正文和图片重新生成bodypart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mimeMultipart);
        // 描述数据关系：附件
        MimeMultipart mimeMultipart2 = new MimeMultipart();
        mimeMultipart2.addBodyPart(attach);
        mimeMultipart2.addBodyPart(attach2);
        mimeMultipart2.addBodyPart(attach3);
        // 附件与正文组合
        mimeMultipart2.addBodyPart(content);
        mimeMultipart2.setSubType("mixed");
        /*
Multipart/mixed:表示消息体中的内容是混合组合类型，可以是文本，声音和附件等不同邮件内容的混合体。
Multipart/related:表示消息体中的内容是关联（依赖）组合类型，表示消息体中的某些内容，依赖另外的资源。
Multipart/alternative:选择组合类型。
         */
        
        message.setContent(mimeMultipart2);// 邮件内容
        message.saveChanges();
        Date date = new Date();
        message.writeTo(new FileOutputStream("E:\\JavaMailData\\NetPartMail-"+date.getTime()+".eml"));
        return message;
    }

    // 创建Html格式的邮件
    // 如果报错：com.sun.mail.smtp.SMTPSendFailedException: 554 DT:SPM 126 smtp9,NeRpCgBHWNowKB1et5sWAg--
    // 是因为被当成垃圾邮件了。
    // 抄送给自己一份，有时会发送成功。
    public MimeMessage createHtmlMail(Session session,String sender,String recipient,String copyTo) throws AddressException, MessagingException, FileNotFoundException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        //message.setRecipient(Message.RecipientType.CC, new InternetAddress(copyTo));
        message.setRecipients(Message.RecipientType.CC, new InternetAddress[] {new InternetAddress(copyTo),new InternetAddress(sender)});
        message.setSubject("这是邮件的标题","UTF-8");

        // 邮件正文
        MimeBodyPart text = new MimeBodyPart();
        String htmlEmailContent = "<html><h6>这是一张用于测试的图片，</h6><img src=\"/file/2020-01-12.jpg\"></html>";
        text.setContent(htmlEmailContent,"text/html;charset=UTF-8");
        // 邮件图片
        MimeBodyPart image = new MimeBodyPart();
        String imagePath = "D:\\EclipseWorkSpace\\workspace03\\shiningcity190201-maven-mybatis\\src\\main\\webapp\\file\\2020-01-12.jpg";
        image.setDataHandler(new DataHandler(new FileDataSource(imagePath)));
        image.setContentID("2020-01-12.jpg");
        // Html页面
        MimeBodyPart attach3 = new MimeBodyPart();
        DataHandler dataHandler3 = new DataHandler(new URL("http://www.apache.org"));
        
        attach3.setDataHandler(dataHandler3);
        attach3.setFileName(dataHandler3.getName());
        // 描述数据关系：正文和图片
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");
        // 正文和图片重新生成bodypart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mimeMultipart);
        // 描述数据关系：附件
        MimeMultipart mimeMultipart2 = new MimeMultipart();
        mimeMultipart2.addBodyPart(attach3);
        // 附件与正文组合
        mimeMultipart2.addBodyPart(content);
        mimeMultipart2.setSubType("mixed");
        /*
Multipart/mixed:表示消息体中的内容是混合组合类型，可以是文本，声音和附件等不同邮件内容的混合体。
Multipart/related:表示消息体中的内容是关联（依赖）组合类型，表示消息体中的某些内容，依赖另外的资源。
Multipart/alternative:选择组合类型。
         */
        
        message.setContent(mimeMultipart2);// 邮件内容
        message.saveChanges();
        Date date = new Date();
        message.writeTo(new FileOutputStream("E:\\JavaMailData\\HtmlMail-"+date.getTime()+".eml"));
        return message;
    }
    
    
}
