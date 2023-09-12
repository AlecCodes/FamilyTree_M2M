package com.example.ft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ft.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
