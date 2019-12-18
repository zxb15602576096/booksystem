package com.example.booksystem.controller;

import com.example.booksystem.mail.Mail;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import com.example.booksystem.service.MapperInsert;
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
public class Insert {
    @Autowired
    MapperInsert mapperInsert;
    @Autowired
    MapperUpdate mapperUpdate;
    @Autowired
    MapperSelect mapperSelect;

    @ResponseBody
    @RequestMapping("/insertuser")
    public void insertuser(User user)
    {
        user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes()));  //加密密码
        System.out.println(user);
        mapperInsert.insertuser(user);
    }

    @ResponseBody
    @RequestMapping("/insertbook")
    public void insertbook(Book book)
    {
        System.out.println(book);
        mapperInsert.insertbook(book);
    }

    @ResponseBody
    @RequestMapping("/insertborrow")
    public void insertborrow(Borrow borrow)
    {
        System.out.println(borrow);
        Map<String,Object> map=new HashMap<>();
        map.put("bookid",borrow.getBookid());
        List<Book> books=mapperSelect.selectonebook(map);
        Book book=books.get(0);
        int number= Integer.parseInt(book.getQuantity())-1;
        book.setQuantity(Integer.toString(number));
        mapperUpdate.updatebook(book);
        mapperInsert.insertborrow(borrow);
    }


    //注册
    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestParam(value = "receive",required = false) String receive) throws Exception {
        //receive：收件人
        Random random= new Random();
        int number=random.nextInt(9000)+1000;  //随机生成1000到9999的数
        System.out.println(number+"    "+receive);
        String value=Integer.toString(number);
        Mail.mail(receive,value,"注册");
        return value;
    }

}
