package com.example.booksystem.mapper;

import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository  //注解接口
public interface Mapperselect {
    List<Book> selectallbook();  //查询所有书籍信息
    List<User> selectalluser();  //查询所有用户信息
    List<Borrow> selectallborrow();  //查询所有借阅信息
    List<Book> selectonebook(Map<String,Object> map);  //按条件查找书籍信息
    List<User> selectoneuser(Map<String,Object> map);  //按条件查找用户信息
    List<Borrow> selectoneborrow(Map<String,Object> map);  //按条件查找借阅信息
    List<Borrow> selectmore(Map<String,Object> map);  //按条件查找借阅信息
    List<Borrow> selectmorefuzzy(String value);  //模糊查询所有借阅信息

    List<User> selectuserfuzzy(String value);
    List<Book> selectbookfuzzy(String value);
}
