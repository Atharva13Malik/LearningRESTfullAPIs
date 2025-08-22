package com.codingshuffleyoutube.LearningRESTfullAPIs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    // --- Getters ---
    public long getId() {
        return id;   // return actual id
    }

    public String getName() {
        return name; // return actual name
    }

    public String getEmail() {
        return email; // return actual email
    }

    // --- Setters ---
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
