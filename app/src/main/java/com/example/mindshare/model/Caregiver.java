package com.example.mindshare.model;

public class Caregiver {

    private String id;
    private String firstName;
    private String lastName;
    private int imageId;

    public Caregiver(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
