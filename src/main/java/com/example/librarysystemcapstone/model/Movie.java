package com.example.librarysystemcapstone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends LendableMaterial{
    @Id
    @GeneratedValue
    private Integer id;
    private String director;

    @Enumerated(EnumType.ORDINAL)
    private StarRating rating;
}
