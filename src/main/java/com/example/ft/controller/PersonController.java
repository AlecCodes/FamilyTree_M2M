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

import javax.swing.text.html.Option;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public List<Person> getPeople() {return personRepository.findAll();}

    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable long id){
         Person _person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: "+ id));
         return Optional.of(_person);
    }


    //Is this really how I want to handle the request?
    @PostMapping("/")
    public Optional<Person> postRoute(@RequestBody Person request){
        Person _person = personRepository.save(new Person(request.getName(), request.getBirthday(), new ArrayList<Person>()));
        return Optional.of(_person);
    }

    @PostMapping("/{personId}/{parentId}")
    public Optional<Person> addParent(@PathVariable long personId, @PathVariable long parentId) {
        Person _parent = personRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Couldn't find parent with id: " + parentId));
        //Get the parents array, then add parent
        Person _person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Couldn't find person with id: " + personId));
        _person.getParents().add(_parent);
        return Optional.of(_person);
    }

    @PutMapping("/{personId}")
    public Optional<Person> editPerson(@PathVariable long personId, @RequestBody Person request){
        Person _person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Couldn't find person w id: " + personId));
        _person.setBirthday(request.getBirthday());
        _person.setName(request.getName());
        return Optional.of(personRepository.save(_person));
    }



    //Perhaps the parentid column in our db is causing issues. Is it being used?
    //

//    public ResponseEntity<String> postRoute(@RequestBody CreatePersonRequest request){
//        try{
//            List<Long> parentIds = request.getParentIds();
//            ArrayList<Person> parents = new ArrayList<>();
//            System.out.println("Hello");
//            for (Long parentId : parentIds){
//
//                System.out.println("Inside loop, looking for first parent");
//
//                Optional<Person> _parent = personRepository.findById(parentId);
//                System.out.println("Inside for loop, just looked up parent");
//                if (_parent.isPresent()) {
//                    //Get method of optional, not entity
//                    parents.add(_parent.get());
//                }else{
//                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Parent with ID " + parentId + " not found");
//                }
//            }
//            personRepository.save(new Person(request.getName(), request.getBirthday(), parents));
//            return ResponseEntity.ok("good request");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Creating Person.");
//        }
//    }
}
