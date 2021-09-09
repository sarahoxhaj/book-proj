package com.library.model;

public class Book {
    private long book_id;
    private String book_title;
    private String book_author;
    private int book_year;

    public Book(long book_id, String book_title, String book_author, int book_year) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_year = book_year;
    }

    public Book() {
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public int getBook_year() {
        return book_year;
    }

    public void setBook_year(int book_year) {
        this.book_year = book_year;
    }
}
