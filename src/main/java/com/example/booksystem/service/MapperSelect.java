package com.example.booksystem.service;

import com.example.booksystem.mapper.Mapperselect;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MapperSelect {
    @Autowired
    Mapperselect mapperselect;  //创建接口
    //查找所有书籍
    public List<Book> selectallbook()
    {
        return mapperselect.selectallbook();  //实现接口的方法
    }
    //查找所有用户
    public List<User> selectalluser()
    {
        return mapperselect.selectalluser();  //实现接口的方法
    }
    //查找所有借阅
    public List<Borrow> selectallborrow()
    {
        return mapperselect.selectallborrow();  //实现接口的方法
    }
    //按条件查询一个书籍信息
    public List<Book> selectonebook(Map<String,Object> map)
    {
        return mapperselect.selectonebook(map);
    }
    //按条件查询一个用户信息
    public List<User> selectoneuser(Map<String,Object> map)
    {
        return mapperselect.selectoneuser(map);
    }
    //按条件查询一个借阅信息
    public List<Borrow> selectoneborrow(Map<String,Object> map)
    {
        return mapperselect.selectoneborrow(map);
    }
    //多表查询所有借阅信息
    public List<Borrow> selectmore(Map<String,Object> map)
    {
        return mapperselect.selectmore(map);
    }
    public List<Borrow> selectmorefuzzy(String value)
    {
        return mapperselect.selectmorefuzzy(value);
    }

    public List<User> selectuserfuzzy(String value)
    {
        return mapperselect.selectuserfuzzy(value);
    }
    public List<Book> selectbookfuzzy(String value)
    {
        return mapperselect.selectbookfuzzy(value);
    }
}
