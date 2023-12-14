package com.example.bookexample.presentation;

import com.example.bookexample.model.Book;
import com.example.bookexample.service.BookService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.List;

@SpringComponent
public class BookCrudListener implements CrudListener {

    private final BookService bookService;
    public BookCrudListener(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Collection findAll() {
        List<Book> books = bookService.findAllBooks();
        return books;
    }

    @Override
    public Object add(Object o) {
        Book b = (Book)o;
        bookService.addBook(b);
        return b;
    }

    @Override
    public Object update(Object o) {
        Book b = (Book)o;
        bookService.updateBook(b);
        return b;
    }

    @Override
    public void delete(Object o) {
        Book b = (Book)o;
        bookService.deleteBookByNumber(b.getNumber());
    }
}
