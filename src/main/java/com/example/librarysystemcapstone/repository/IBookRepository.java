package com.example.librarysystemcapstone.repository;

import com.example.librarysystemcapstone.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByTitleContains(String filter);
}
