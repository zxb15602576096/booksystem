package com.example.booksystem.mail;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class CreateMail {

    public static MimeMessage create(Session session,String send,String receive,String value,String content) throws Exception {
        //session 对象
        //send 发送人
        //receive  收件人
        //value 验证码
        MimeMessage mimeMessage=new MimeMessage(session);
        //创建发送人
        Address address=new InternetAddress(send,"图书管理系统","UTF-8");
        mimeMessage.setFrom(address);
        //设置标题，编码
        mimeMessage.setSubject(content,"UTF-8");
        //设置正文内容，编码
        mimeMessage.setContent("【图书管理系统】您的验证码是："+value,"text/html; charset=utf-8");
        //收件人类型：TO:普通收件人，CC：抄送人，BCC：密送人  （一个用setRecipient，多个用setRecipients）
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receive,"收件人","UTF-8"));
//        mimeMessage.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress(receive,"抄送人","UTF-8"));
//        mimeMessage.setRecipient(MimeMessage.RecipientType.BCC,new InternetAddress(receive,"密送人","UTF-8"));
        //设置发送日期
        mimeMessage.setSentDate(new Date());
        //保存邮件
        mimeMessage.saveChanges();

        return mimeMessage;
    }

}
