package com.example.librarysystemcapstone.service;

import com.example.librarysystemcapstone.model.Book;
import com.example.librarysystemcapstone.repository.IBookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class BookServiceImpl implements IBookService{

    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Iterable<Book> booksIts = bookRepository.findAll();
        booksIts.forEach(books::add);
        log.debug("BookServiceImpl: findAll called");
        return books;
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        log.debug("BookServiceImpl: findById called for id: " + id);
        return book.orElseThrow();
    }

    @Override
    public List<Book> findByTitleContains(String filter) {
        List<Book> books = new ArrayList<>();
        Iterable<Book> booksIts = bookRepository.findByTitleContains(filter);
        booksIts.forEach(books::add);
        log.debug("BookServiceImpl: findByTitleContains called for filter: " + filter);
        return books;
    }
}
