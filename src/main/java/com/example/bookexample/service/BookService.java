package com.example.bookexample.service;

import com.example.bookexample.model.Book;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> findAllBooks();
    Book findBookByNumber(long number);
    void addBook(Book b);
    void updateBook (Book b);
    void deleteBook(Book b);
    void deleteBookByNumber(long number);
    void deleteAllBooks();
}
