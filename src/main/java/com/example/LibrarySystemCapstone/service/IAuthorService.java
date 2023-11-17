package com.example.LibrarySystemCapstone.service;

import com.example.LibrarySystemCapstone.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    Author findById(Integer id);
    List<Author> findByNameContains(String filter);
}
