package com.example.librarysystemcapstone.repository;

import com.example.librarysystemcapstone.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByTitleContains(String filter);
}
