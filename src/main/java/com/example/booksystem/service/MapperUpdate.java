package com.example.booksystem.service;

import com.example.booksystem.mapper.Mapperupdate;
import com.example.booksystem.model.Book;
import com.example.booksystem.model.Borrow;
import com.example.booksystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperUpdate {
    @Autowired
    Mapperupdate mapperupdate;

    public void updateuser(User user)
    {
        mapperupdate.updateuser(user);
    }

    public void updatebook(Book book)
    {
        mapperupdate.updatebook(book);
    }

    public void updateborrow(Borrow borrow)
    {
        mapperupdate.updateborrow(borrow);
    }
}
