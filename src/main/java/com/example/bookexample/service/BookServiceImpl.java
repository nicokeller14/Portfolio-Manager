package com.example.bookexample.service;

import com.example.bookexample.model.Book;
import com.example.bookexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    ArrayList<Book> bookList = new ArrayList<>();
    @Override
    public ArrayList<Book> findAllBooks() {

        ArrayList<Book> bookListRepo = (ArrayList<Book>) bookRepository.findAll();
        if (bookListRepo.isEmpty())
            return bookList;
        else
            return bookListRepo;
    }
    @Override
    public Book findBookByNumber(long number) {

        return bookRepository.findByNumber(number);

    }
    @Override
    public void addBook(Book b) {
        bookList.add(b);
        bookRepository.save(b);
    }
    @Override
    public void deleteAllBooks() {
        bookList.clear();
        bookRepository.deleteAll();
    }
    @Override
    public void deleteBook(Book b) {
        Book deleteBook = null;
        for (Book book : stockList) {
            if (book.getNumber() == b.getNumber()) {
                deleteBook = b;
            }
        }

        if (deleteBook != null) {
            bookList.remove(deleteBook);
            bookRepository.delete(deleteBook);

        }
    }

    @Override
    public void deleteBookByNumber(long number) {
        Book deleteBook = null;
        for (Book b : bookList) {
            if (b.getNumber() == number) {
                deleteBook = b;
            }
        }

        if (deleteBook != null) {
            bookList.remove(deleteBook);
            bookRepository.delete(deleteBook);

        }
    }

    @Override
    public void updateBook(Book b) {
        for (Book book : bookList) {
            if (book.getNumber() == b.getNumber()) {
                book.setName(b.getName());
                book.setTitle(b.getTitle());
                bookRepository.save(book);
            }
        }
    }
}
