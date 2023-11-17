package com.example.LibrarySystemCapstone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends Person{

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Book> books;
}
