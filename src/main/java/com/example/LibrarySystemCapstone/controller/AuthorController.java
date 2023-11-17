package com.example.LibrarySystemCapstone.controller;

import com.example.LibrarySystemCapstone.model.Author;
import com.example.LibrarySystemCapstone.service.IAuthorService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AuthorController {
    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors(@PathParam("filter") String filter){
        List<Author> authors;
        if (StringUtils.isNotBlank(filter)){
            authors = authorService.findByNameContains(filter);
            log.debug("AuthorController: getAllAuthors called with filter: " + filter);
        } else{
            authors = authorService.findAll();
            log.debug("AuthorController: getAllAuthors called");
        }
        return authors;
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable int id){
        log.debug("AuthorController: getAuthorById called with id: " + id);
        Author author = authorService.findById(id);
        log.debug(author.toString());
        return author;
    }
}
