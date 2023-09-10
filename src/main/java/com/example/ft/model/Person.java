package com.example.ft.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name="people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "people_seq", allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    //An Eager fetch type will fetch the parent collection during the hibernate session.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_parent",
            joinColumns = @JoinColumn(name="child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<Person> parents = new ArrayList<>();

    /////////////////////
    //Constructor
    /////////////////////
    public Person(){}
    //Is this a valid arraylist param?
    public Person(String name, Date birthday, ArrayList<Person> parents){
        this.name = name;
        this.birthday = birthday;
        this.parents = parents;
    }

    /////////////////////
    //GETTERS N SETTERS
    /////////////////////

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }
}
