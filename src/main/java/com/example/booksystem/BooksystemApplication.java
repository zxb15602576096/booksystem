package com.example.booksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.booksystem.mapper")  //扫描配置文件的包
@SpringBootApplication
public class BooksystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksystemApplication.class, args);
    }

}
