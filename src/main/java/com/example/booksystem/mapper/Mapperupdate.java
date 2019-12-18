package com.example.booksystem.mapper;

import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Mapperupdate {

    void updateuser(@Param("user") User user); //更新一个用户信息
    void updatebook(@Param("book") Book book); //更新一个书籍信息
    void updateborrow(@Param("borrow") Borrow borrow); //更新一个借阅信息
}
