package com.example.LibrarySystemCapstone.util;

import com.example.LibrarySystemCapstone.repository.IAuthorRepository;
import com.example.LibrarySystemCapstone.repository.IBookRepository;
import com.example.LibrarySystemCapstone.repository.IMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Populator {
    private IAuthorRepository authorRepository;
    private IBookRepository bookRepository;
    private IMovieRepository movieRepository;
}
