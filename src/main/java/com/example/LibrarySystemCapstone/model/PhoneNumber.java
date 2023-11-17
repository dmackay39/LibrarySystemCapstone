package com.example.LibrarySystemCapstone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue
    private Integer id;
    private int countryCode;
    private int number;
}
