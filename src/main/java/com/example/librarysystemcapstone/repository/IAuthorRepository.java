package com.example.librarysystemcapstone.repository;

import com.example.librarysystemcapstone.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findByNameContains(String filter);
}
