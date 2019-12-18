package com.example.booksystem.model;

public class Book {
    private String bookid;
    private String bookname;
    private String quantity;
    private String place;
    private String isborrow;
    private String remark;

    public Book() {}
    public Book(String bookid, String bookname, String quantity, String place, String isborrow, String remark) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.quantity = quantity;
        this.place = place;
        this.isborrow = isborrow;
        this.remark = remark;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getIsborrow() {
        return isborrow;
    }

    public void setIsborrow(String isborrow) {
        this.isborrow = isborrow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid='" + bookid + '\'' +
                ", bookname='" + bookname + '\'' +
                ", quantity='" + quantity + '\'' +
                ", place='" + place + '\'' +
                ", isborrow='" + isborrow + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
