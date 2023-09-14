package com.example.ft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ft.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p JOIN p.parents parent WHERE parent.id = :personId")
    List<Person> findChildrenByPersonId(@Param("personId") Long personId);
}
