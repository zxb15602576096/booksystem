package com.example.booksystem.mail;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    public static void mail(String receive,String value,String content) throws Exception {
        Properties properties=new Properties();
        //发送邮件使用的协议，smtp
        properties.setProperty("mail.transport.protocol","smtp");
        //协议的地址(qq邮箱的协议地址)
        properties.setProperty("mail.smtp.host","smtp.qq.com");
        //协议端口（qq邮箱的协议端口）
        properties.setProperty("mail.smtp.port","465");
        //需要授权
        properties.setProperty("mail.smtp.auth","true");

        //QQ邮箱需要的SSL安全认证
        //加载java中SSL安全认证的类
        properties.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        //
        properties.setProperty("mail.smtp.socketFactory.fallback","false");
        //认证端口，和协议端口一样
        properties.setProperty("mail.smtp.socketFactory.port","465");

        //创建Session对象
        Session session=Session.getInstance(properties);

        //创建邮件
        String send="2398676165@qq.com";
//        String receive="2926138780@qq.com";
        //创建邮件，调用函数
        MimeMessage mimeMessage= CreateMail.create(session,send,receive,value,content);
        //建立连接
        Transport transport=session.getTransport();
        transport.connect(send,"ycsuwkkedpyudjfc");
        //mimeMessage.getAllRecipients()获取所有收件人
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        //关闭连接
        transport.close();

    }
}


//ycsuwkkedpyudjfc
