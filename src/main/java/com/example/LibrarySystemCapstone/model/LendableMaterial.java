package com.example.LibrarySystemCapstone.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class LendableMaterial {
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
