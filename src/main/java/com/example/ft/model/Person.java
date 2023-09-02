package com.example.ft.model;

import jakarta.persistence.*;

@Entity
@Table(name="people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "people_seq", allocationSize = 1)
    private long id;


}
