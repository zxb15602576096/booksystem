package com.example.booksystem.controller;

import com.example.booksystem.mail.Mail;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import com.example.booksystem.service.MapperSelect;
import com.example.booksystem.service.MapperUpdate;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class Update {

    @Autowired
    MapperUpdate mapperUpdate;

    @ResponseBody
    @RequestMapping("/updateuser")
    public void updateuser(User user)
    {
        System.out.println(user.getPassword());
        if (user.getPassword()!=null&&user.getPassword()!=""){         //判断密码是否为""只是null还不行
            user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes()));  //加密密码
        }
        System.out.println(user);
        mapperUpdate.updateuser(user);
    }

    @ResponseBody
    @RequestMapping("/updatebook")
    public void updatebook(Book book)
    {
        System.out.println(book);
        mapperUpdate.updatebook(book);
    }

    @ResponseBody
    @RequestMapping("/updateborrow")
    public void updateborrow(Borrow borrow)
    {
        System.out.println(borrow);
        User user=borrow.getUser();
        user.setId(borrow.getId());   //set用户id
        mapperUpdate.updateuser(user);  //更新用户的信息

        Book book=borrow.getBook();
        book.setBookid(borrow.getBookid());  //set书籍id
        mapperUpdate.updatebook(book);  //更新书籍信息

        System.out.println(borrow);
        mapperUpdate.updateborrow(borrow);
    }


    //找回密码
    @ResponseBody
    @RequestMapping("/findpassword")
    public String findpassword(@RequestParam(value = "receive",required = false) String receive) throws Exception {
        //receive：收件人
        Random random= new Random();
        int number=random.nextInt(9000)+1000;  //随机生成1000到9999的数
        System.out.println(number+"    "+receive);
        String value=Integer.toString(number);
        Mail.mail(receive,value,"重置密码");
        return value;
    }

}
