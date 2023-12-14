package com.example.bookexample.presentation;

import com.example.bookexample.model.Book;
import com.example.bookexample.service.BookService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.impl.GridCrud;


@Route("books")
public class MainView extends VerticalLayout {

    @Autowired
    public MainView(BookService bookService) {

        removeAll();

        GridCrud<Book> bookGridCrud = new GridCrud<>(Book.class);
        bookGridCrud.setCrudListener(new BookCrudListener(bookService));

        add(bookGridCrud);

    }

}
