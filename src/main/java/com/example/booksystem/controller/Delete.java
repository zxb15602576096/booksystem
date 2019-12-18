package com.example.booksystem.controller;

import com.example.booksystem.model.User;
import com.example.booksystem.service.MapperDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Delete {
    @Autowired
    MapperDelete mapperDelete;

    @ResponseBody
    @RequestMapping("/deleteuser")
    public void deleteuser(@RequestParam(value = "ids",required = false) List<String> ids)
    {
        System.out.println(ids);
        mapperDelete.deleteborrowbyuserid(ids); //先删除borrow中有该id的信息
        mapperDelete.deleteuser(ids);
    }

    @ResponseBody
    @RequestMapping("/deletebook")
    public void deletebook(@RequestParam(value = "bookids",required = false) List<String> bookids)
    {
        mapperDelete.deleteborrowbybookid(bookids);  //先删除borrow表中有该bookid的信息
        mapperDelete.deletebook(bookids);
    }

    @ResponseBody
    @RequestMapping("/deleteborrowbyborrowid")
    public void deleteborrowbyborrowid(@RequestParam(value = "borrowids",required = false) List<String> borrowids)
    {
        System.out.println(borrowids);
        mapperDelete.deleteborrowbyborrowid(borrowids);
    }
}
