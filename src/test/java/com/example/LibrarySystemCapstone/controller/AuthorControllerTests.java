package com.example.LibrarySystemCapstone.controller;

import com.example.LibrarySystemCapstone.model.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Sql("classpath:test-data.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class AuthorControllerTests {

    @Autowired
    AuthorController authorController;

    @Test
    public void testGetAllAuthors(){
        int expectedSize = 1;
        List<Author> authors = authorController.getAllAuthors("");
        Assertions.assertEquals(expectedSize, authors.size());
    }

    @Test
    public void testGetOneAuthor(){
        int testAuthorId = 1;
        Author author = authorController.getAuthorById(testAuthorId);
        Assertions.assertAll(
                () -> Assertions.assertTrue(author.getName().equals("Robert C Martin")),
                () -> Assertions.assertTrue(author.getEmail().equals("Robert@clean.com"))
        );
    }
}
