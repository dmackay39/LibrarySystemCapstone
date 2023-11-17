package com.example.LibrarySystemCapstone.service;

import com.example.LibrarySystemCapstone.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    List<Book> findByTitleContains(String filter);
}
