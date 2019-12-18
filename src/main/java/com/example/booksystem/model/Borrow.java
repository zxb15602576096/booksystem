package com.example.booksystem.model;

public class Borrow {
    private String borrowid;
    private String bookid;
    private String id;
    private String borrowtime;
    private String returntime;
    private User user;
    private Book book;

    public Borrow() {
    }

    public Borrow(String borrowid, String bookid, String id, String borrowtime, String returntime, User user, Book book) {
        this.borrowid = borrowid;
        this.bookid = bookid;
        this.id = id;
        this.borrowtime = borrowtime;
        this.returntime = returntime;
        this.user = user;
        this.book = book;
    }

    public String getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(String borrowid) {
        this.borrowid = borrowid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    public String getReturntime() {
        return returntime;
    }

    public void setReturntime(String returntime) {
        this.returntime = returntime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowid='" + borrowid + '\'' +
                ", bookid='" + bookid + '\'' +
                ", id='" + id + '\'' +
                ", borrowtime='" + borrowtime + '\'' +
                ", returntime='" + returntime + '\'' +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
