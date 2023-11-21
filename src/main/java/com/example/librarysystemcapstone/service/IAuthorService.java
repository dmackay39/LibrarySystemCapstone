package com.example.librarysystemcapstone.service;

import com.example.librarysystemcapstone.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    Author findById(Integer id);
    List<Author> findByNameContains(String filter);
    Author save(Author author);
}
