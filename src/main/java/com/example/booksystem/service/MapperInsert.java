package com.example.booksystem.service;

import com.example.booksystem.mapper.Mapperinsert;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperInsert {
    @Autowired
    Mapperinsert mapperinsert;

    public void insertuser(User user) {mapperinsert.insertuser(user);}  //插入用户信息
    public void insertbook(Book book) {mapperinsert.insertbook(book);}  //插入书籍信息
    public void insertborrow(Borrow borrow) {mapperinsert.insertborrow(borrow);}  //插入借阅信息

}
