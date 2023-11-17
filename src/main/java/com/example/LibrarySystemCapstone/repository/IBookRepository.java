package com.example.LibrarySystemCapstone.repository;

import com.example.LibrarySystemCapstone.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByTitleContains(String filter);
}
