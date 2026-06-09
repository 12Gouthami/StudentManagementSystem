package com.airtribe.learning.entity;

public class Student extends Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String batch;
    private boolean active;

    // Default constructor
    public Student() {
    }

    // Constructor without email (Overloading)
    public Student(int id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, null); // using super
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.batch = batch;
        this.active = true;
    }

    // Constructor with email (Overloading)
    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email); // using super
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.batch = batch;
        this.active = true;
    }


    // Overriding method
    @Override
    public String getDisplayName() {
        return "Student: " + firstName + " " + lastName;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
