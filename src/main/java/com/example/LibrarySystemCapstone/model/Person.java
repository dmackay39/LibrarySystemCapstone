package com.example.LibrarySystemCapstone.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person {
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    private PhoneNumber phoneNumber;

}
