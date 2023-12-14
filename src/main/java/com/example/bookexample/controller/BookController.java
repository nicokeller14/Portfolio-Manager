package com.example.bookexample.controller;

import com.example.bookexample.model.Book;
import com.example.bookexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/findall", produces = "application/json")
    public ArrayList<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping(value = "/findbynumber/{number}", produces = "application/json")
    public Book geBookByNumber(@PathVariable long number) {
        return bookService.findBookByNumber(number);
    }

    @PutMapping(value = "/updatebook/{number}", consumes = "application/json")
    public ResponseEntity updateBook(@PathVariable long number, @RequestBody Book book) {
        if (number == book.getNumber()) {
            bookService.updateBook(book);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //This happens when the number in the URI does not match the provided number in the body

    }

    @DeleteMapping("/deleteall")
    public ResponseEntity deleteAllBooks() {
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/deletebynumber/{number}")
    public ResponseEntity deleteBookByNumber(@PathVariable long number) {
        bookService.deleteBookByNumber(number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
