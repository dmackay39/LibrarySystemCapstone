package com.example.librarysystemcapstone.service;

import com.example.librarysystemcapstone.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll();
    Movie findById(Integer id);
    List<Movie> findByTitleContains(String filter);
    Movie save(Movie movie);
    void deleteById(Integer id);
}
