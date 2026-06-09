package com.airtribe.learning.entity;

public class Person {

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Method to be overridden
    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
