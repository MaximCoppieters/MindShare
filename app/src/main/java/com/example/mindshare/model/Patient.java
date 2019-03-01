package com.example.mindshare.model;

public class Patient {

    private String firstName;
    private String lastName;
    private String password;
    private int imageId;

    public Patient(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getImageId() {
        return imageId;
    }

    public String getFullName() {
        return firstName + lastName;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}