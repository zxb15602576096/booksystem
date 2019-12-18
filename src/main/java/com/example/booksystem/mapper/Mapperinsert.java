package com.example.booksystem.mapper;

import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mapperinsert {

//    要加上@Param()标签，说明user（和mapper中的user.name中的user一致）是个对象映射，传到mapper中
    void insertuser(@Param("user") User user);  //插入一个用户

    void insertbook(@Param("book") Book book);

    void insertborrow(@Param("borrow") Borrow borrow);

}
