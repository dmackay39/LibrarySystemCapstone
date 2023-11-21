package com.example.librarysystemcapstone.controller;

import com.example.librarysystemcapstone.model.Movie;
import com.example.librarysystemcapstone.service.IMovieService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MovieController {
    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(@PathParam("filter") String filter){
        List<Movie> movies;
        if (StringUtils.isNotBlank(filter)){
            movies = movieService.findByTitleContains(filter);
            log.debug("MovieController: getAllMovies called with filter: " + filter);
        } else {
            movies = movieService.findAll();
            log.debug("MovieController: getAllMovies called");
        }
        return movies;
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable int id){
        log.debug("MovieController: getMoviesById called with id: " + id);
        return movieService.findById(id);
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovieById(@PathVariable int id){
        movieService.deleteById(id);
    }
}
