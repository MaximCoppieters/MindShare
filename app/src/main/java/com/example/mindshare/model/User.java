package com.example.mindshare.model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String firstName;
    private String lastName;
    private String password;
    private int imageId;
    private List<Message> inbox;
    private List<Message> outbox;

    public User(String firstName, String lastName, String password) {
        inbox = new ArrayList<>();
        outbox = new ArrayList<>();
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

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void sendMessage(Message message, User receiver) {
        receiver.inbox.add(message);
        this.outbox.add(message);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
