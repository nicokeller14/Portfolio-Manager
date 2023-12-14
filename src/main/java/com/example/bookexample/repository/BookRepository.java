package com.example.bookexample.repository;

import com.example.bookexample.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByName(String name);
    Book findByNumber(long number);


}
