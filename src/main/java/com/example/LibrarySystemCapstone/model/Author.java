package com.example.LibrarySystemCapstone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author extends Person{

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
