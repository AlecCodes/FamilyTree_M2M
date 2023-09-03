package com.example.ft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.example.ft.DTO.CreatePersonRequest;
import com.example.ft.model.Person;
import com.example.ft.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public List<Person> getPeople() {return personRepository.findAll();}

    //Use a DTO instead of entity type?
    @PostMapping("/")
    public ResponseEntity<String> postRoute(@RequestBody CreatePersonRequest request){
        try{
            List<Long> parentIds = request.getParentIds();
            List<Person> parents = new ArrayList<>();
            return ResponseEntity.ok("good request");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Creating Person.");
        }
    }
}
