package com.example.ft.model;

import jakarta.persistence.*;

import java.util.Date;
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

    @ManyToMany
    @JoinTable(
            name = "person_parent",
            joinColumns = @JoinColumn(name="child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private ArrayList<Person> parents = new ArrayList<>();

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

    public ArrayList<Person> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Person> parents) {
        this.parents = parents;
    }
}
