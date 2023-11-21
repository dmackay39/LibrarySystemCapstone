package com.example.librarysystemcapstone.service;

import com.example.librarysystemcapstone.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    List<Book> findByTitleContains(String filter);
}
