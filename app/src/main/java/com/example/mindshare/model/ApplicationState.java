package com.example.mindshare.model;

public class ApplicationState<T extends User> {

    private static final ApplicationState instance = new ApplicationState();

    private User loggedInUser;
    private Class<T> userType;

    private ApplicationState() { }

    public Class<T> getUserType() {
        return userType;
    }

    public void setUserType(Class<T> userType) {
        this.userType = userType;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public User getLoggedInUser() {
        if (loggedInUser == null) {
            return new Patient("Test", "lastname", "password");
        }
        return loggedInUser;
    }

    public static ApplicationState getInstance() {
        return instance;
    }
}
