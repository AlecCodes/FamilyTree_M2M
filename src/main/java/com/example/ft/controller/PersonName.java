package com.example.ft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ft.model.Person;
import com.example.ft.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonName {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public List<Person> getPeople() {return personRepository.findAll();}
}
