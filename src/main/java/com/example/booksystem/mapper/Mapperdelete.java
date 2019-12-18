package com.example.booksystem.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mapperdelete {

    void deleteuser(List<String> ids); //删除用户
    void deletebook(List<String> bookids); //删除书籍
    void deleteborrowbyborrowid(List<String> borrowids); //通过borrowid删除借阅
    void deleteborrowbybookid(List<String> bookids); //通过bookid删除借阅
    void deleteborrowbyuserid(List<String> ids); //通过id删除借阅
}
