package com.udacity.DogGraphQL.entity;

import javax.persistence.*;

@Entity
public class DogBreed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String breed;
    private String name;

    public DogBreed(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DogBreed(Long id, String breed, String name) {
        this.id = id;
        this.breed = breed;
        this.name = name;
    }

    public DogBreed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
