package com.example.LibrarySystemCapstone.service;

import com.example.LibrarySystemCapstone.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll();
    Movie findById(Integer id);
    List<Movie> findByTitleContains(String filter);
}
