package com.example.booksystem.service;

import com.example.booksystem.mapper.Mapperdelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperDelete {
    @Autowired
    Mapperdelete mapperdelete;

    public void deleteuser (List<String> ids)
    {
        mapperdelete.deleteuser(ids);
    }

    public void deletebook (List<String> bookids)
    {
        mapperdelete.deletebook(bookids);
    }
    public void deleteborrowbyborrowid (List<String> borrowids)
    {
        mapperdelete.deleteborrowbyborrowid(borrowids);
    }
    public void deleteborrowbybookid (List<String> bookids)
    {
        mapperdelete.deleteborrowbybookid(bookids);
    }
    public void deleteborrowbyuserid (List<String> ids)
    {
        mapperdelete.deleteborrowbyuserid(ids);
    }
}
