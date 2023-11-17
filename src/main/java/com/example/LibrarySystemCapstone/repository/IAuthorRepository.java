package com.example.LibrarySystemCapstone.repository;

import com.example.LibrarySystemCapstone.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findByNameContains(String filter);
}
