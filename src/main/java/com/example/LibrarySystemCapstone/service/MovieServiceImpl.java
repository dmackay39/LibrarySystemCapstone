package com.example.LibrarySystemCapstone.service;

import com.example.LibrarySystemCapstone.model.Movie;
import com.example.LibrarySystemCapstone.repository.IMovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class MovieServiceImpl implements IMovieService{

    private IMovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> moviesIts = movieRepository.findAll();
        moviesIts.forEach(movies::add);
        log.debug("MovieServiceImpl: findAll called");
        return movies;
    }

    @Override
    public Movie findById(Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);
        log.debug("MovieServiceImpl: findById called for id: " + id);
        return movie.orElseThrow();
    }

    @Override
    public List<Movie> findByTitleContains(String filter) {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> moviesIts = movieRepository.findByTitleContains(filter);
        moviesIts.forEach(movies::add);
        log.debug("MovieServiceImpl: findByTitleContains called with title: " + filter);
        return movies;
    }
}
