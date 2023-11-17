package com.example.LibrarySystemCapstone.service;

import com.example.LibrarySystemCapstone.model.Author;
import com.example.LibrarySystemCapstone.repository.IAuthorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AuthorServiceImpl implements IAuthorService{

    private IAuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        Iterable<Author> authorIts = authorRepository.findAll();
        authorIts.forEach(authors::add);
        log.debug("AuthorServiceImpl: findAll called");
        return authors;
    }

    @Override
    public Author findById(Integer id) {
        Optional<Author> author = authorRepository.findById(id);
        log.debug("AuthorServiceImpl: findById called for id: " + id);
        return author.orElseThrow();
    }

    @Override
    public List<Author> findByNameContains(String filter) {
        List<Author> authors = new ArrayList<>();
        Iterable<Author> authorsIts = authorRepository.findByNameContains(filter);
        authorsIts.forEach(authors::add);
        log.debug("AuthorServiceImpl: findByNameContains called for name: " + filter);
        return authors;
    }
}
