package com.example.booksystem.controller;

import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import com.example.booksystem.service.MapperSelect;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Select {
    @Autowired
    MapperSelect mapperSelect;
//查询所有书籍信息
    @ResponseBody
    @RequestMapping("/selectallbook")
    public List<Book> selectallbook(@RequestParam(value = "search",required = false) String search)
    {
        System.out.println(search);   //判断search是否有东西
        if (search!=null&&search!=""){
            List<Book> books = mapperSelect.selectbookfuzzy(search);
            System.out.println(books);
            return books;
        }
        List<Book> books= mapperSelect.selectallbook();
        System.out.println(books);
        return books;
    }

    //查询所有用户信息
    @ResponseBody
    @RequestMapping("/selectalluser")
    public List<User> selectalluser(@RequestParam(value = "search",required = false) String search)
    {
        System.out.println(search);   //判断search是否有东西
        if (search!=null&&search!=""){
            List<User> users = mapperSelect.selectuserfuzzy(search);
            System.out.println(users);
            return users;
        }
        else {
            List<User> users = mapperSelect.selectalluser();
            System.out.println(users);
            return users;
        }
    }

    //查询所有借阅信息
    @ResponseBody
    @RequestMapping("/selectallborrow")
    public List<Borrow> selectallborrow(@RequestParam(value = "search",required = false) String search)
    {
        System.out.println(search);   //判断search是否有东西
        if (search!=null&&search!=""){
            List<Borrow> borrows = mapperSelect.selectmorefuzzy(search);
            System.out.println(borrows);
            return borrows;
        }
        else {
            List<Borrow> borrows = mapperSelect.selectallborrow();
            System.out.println(borrows);
            return borrows;
        }
    }

    //按一个条件查询书籍信息
    @ResponseBody
    @RequestMapping("/selectonebook")
    public List<Book> selectonebook(@RequestParam(value = "key",required = false) String key,@RequestParam(value = "value",required = false) String value,@RequestParam(value = "key2",required = false) String key2,@RequestParam(value = "value2",required = false) String value2,@RequestParam(value = "key3",required = false) String key3,@RequestParam(value = "value3",required = false) String value3,@RequestParam(value = "search",required = false) String search)
    {
        System.out.println(search);   //判断search是否有东西
        if (search!=null&&search!=""){
            List<Book> books = mapperSelect.selectbookfuzzy(search);
            System.out.println(books);
            return books;
        }
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(key,value);
        map.put(key2,value2);
        map.put(key3,value3);
        List<Book> books= mapperSelect.selectonebook(map);
        System.out.println(books);
        return books;
    }

    //按一个条件查询用户信息
    @ResponseBody
    @RequestMapping("/selectoneuser")
    public List<User> selectoneuser(@RequestParam(value = "key",required = false) String key,@RequestParam(value = "value",required = false) String value,@RequestParam(value = "key2",required = false) String key2,@RequestParam(value = "value2",required = false) String value2,@RequestParam(value = "key3",required = false) String key3,@RequestParam(value = "value3",required = false) String value3,@RequestParam(value = "search",required = false) String search)
    {
        System.out.println(search);   //判断search是否有东西
        if (search!=null&&search!=""){
            List<User> users = mapperSelect.selectuserfuzzy(search);
            System.out.println(users);
            System.out.println("search");
            return users;
        }
        else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(key, value);
            map.put(key2, value2);
            map.put(key3, value3);
            List<User> users = mapperSelect.selectoneuser(map);
            System.out.println(users);
            return users;
        }
    }

    //按一个条件查询借阅信息
    @ResponseBody
    @RequestMapping("/selectoneborrow")
    public List<Borrow> selectoneborrow(@RequestParam(value = "key",required = false) String key,@RequestParam(value = "value",required = false) String value,@RequestParam(value = "key2",required = false) String key2,@RequestParam(value = "value2",required = false) String value2,@RequestParam(value = "key3",required = false) String key3,@RequestParam(value = "value3",required = false) String value3,@RequestParam(value = "search",required = false) String search)
    {
        System.out.println(search);   //判断search是否有东西
        if (search!=null&&search!=""){
            List<Borrow> borrows = mapperSelect.selectmorefuzzy(search);
            System.out.println(borrows);
            return borrows;
        }
        else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(key, value);
            map.put(key2, value2);
            map.put(key3, value3);
            List<Borrow> borrows = mapperSelect.selectoneborrow(map);
            System.out.println(borrows);
            return borrows;
        }
    }

    //登录
    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam(value = "key",required = false) String key, @RequestParam(value = "value",required = false) String value, @RequestParam(value = "key2",required = false) String key2, @RequestParam(value = "value2",required = false) String value2)
    {
        if (key==null||value==null||key2==null||value2==null){return "0";}
        System.out.println(value+"    "+value2);
                Map<String, Object> map = new HashMap<>();
                map.put(key, value);
                value2=DigestUtils.md5Hex(value2.getBytes()); //加密密码
                map.put(key2, value2);
                System.out.println(key + "   " + value + "   " + key2 + "   " + value2);
                List<User> users = mapperSelect.selectoneuser(map);
                if (users.size() == 1)  //判断List是否为空
                {
                    User user = users.get(0);
                    switch (user.getJurisdiction()) {
                        case "1":
                            System.out.println("超级管理员");
                            return "1";//返回权限值，转到超级管理员界面
                        case "2":
                            System.out.println("图书管理员");
                            return "2";//返回权限值，转到图书管理员界面
                        case "3":
                            System.out.println("读者");
                            return "3"; //返回权限值，转到读者界面
                        default:
                            System.out.println("登录失败");
                            return "0";
                    }
                }
            return "0";
    }


    @ResponseBody
    @RequestMapping("/selectmore")
    public List<Borrow> selectmore(@RequestParam(value = "key",required = false) String key,@RequestParam(value = "value",required = false) String value,@RequestParam(value = "key2",required = false) String key2,@RequestParam(value = "value2",required = false) String value2,@RequestParam(value = "key3",required = false) String key3,@RequestParam(value = "value3",required = false) String value3,@RequestParam(value = "search",required = false) String search)
    {
        System.out.println(search);   //判断search是否有东西
        if (search!=null&&search!=""){
            List<Borrow> borrows = mapperSelect.selectmorefuzzy(search);
            System.out.println(borrows);
            return borrows;
        }
        else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(key, value);
            map.put(key2, value2);
            map.put(key3, value3);
            System.out.println(key + "   " + value + "   " + key2 + "   " + value2);
            List<Borrow> borrows = mapperSelect.selectmore(map);
            System.out.println(borrows);
            return borrows;
        }
    }


    //模糊查询所有借阅信息
    @ResponseBody
    @RequestMapping("/selectmorefuzzy")
    public List<Borrow> selectmorefuzzy(@RequestParam(value = "value",required = false) String value)
    {
        List<Borrow> borrows= mapperSelect.selectmorefuzzy(value);
        System.out.println(borrows);
        return borrows;
    }

    @ResponseBody
    @RequestMapping("/selectuserfuzzy")
    public List<User> selectuserfuzzy(@RequestParam(value = "value",required = false) String value)
    {
        List<User> users= mapperSelect.selectuserfuzzy(value);
        System.out.println(users);
        return users;
    }

    @ResponseBody
    @RequestMapping("/selectbookfuzzy")
    public List<Book> selectbookfuzzy(@RequestParam(value = "value",required = false) String value)
    {
        List<Book> books= mapperSelect.selectbookfuzzy(value);
        System.out.println(books);
        return books;
    }
}
