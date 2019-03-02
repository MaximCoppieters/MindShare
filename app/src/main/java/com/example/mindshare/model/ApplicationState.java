package com.example.mindshare.model;

public class ApplicationState<T extends User> {

    private Class<T> userType;
    private static final ApplicationState instance = new ApplicationState();

    private ApplicationState() { }

    public Class<T> getUserType() {
        return userType;
    }

    public void setUserType(Class<T> userType) {
        this.userType = userType;
    }

    public static ApplicationState getInstance() {
        return instance;
    }
}
