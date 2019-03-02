package com.example.mindshare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends User {

    private Caregiver caregiver;
    private List<TodoItem> todoList;

    public Patient(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
        todoList = new ArrayList<>();
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public List<TodoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoItem> todoList) {
        this.todoList = todoList;
    }

    public void addTodoItem(TodoItem todoItem) {
        todoList.add(todoItem);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
