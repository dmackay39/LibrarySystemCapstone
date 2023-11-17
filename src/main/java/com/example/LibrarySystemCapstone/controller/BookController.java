package com.example.LibrarySystemCapstone.controller;

import com.example.LibrarySystemCapstone.model.Book;
import com.example.LibrarySystemCapstone.service.IBookService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(@PathParam("filter") String filter){
        List<Book> books;
        if (StringUtils.isNotBlank(filter)){
            books = bookService.findByTitleContains(filter);
            log.debug("BookController: getAllBooks called with filter: " + filter);
        } else{
            books = bookService.findAll();
            log.debug("BookController: getAllBooks called");
        }
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        log.debug("BookController: getBookById called with id: " + id);
        return bookService.findById(id);
    }
}
