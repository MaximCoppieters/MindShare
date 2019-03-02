package com.pxl.mindshare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private String email;

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

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return imageId == user.imageId &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
