package com.pxl.mindshare.business;

import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.model.User;

public class ApplicationState<T extends User> {

    private static final ApplicationState instance = new ApplicationState();

    private User loggedInUser;
    private Patient selectedPatient;
    private Class<T> userType;
    private String chosenColorDescription;

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

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public static ApplicationState getInstance() {
        return instance;
    }

    public String getChosenColorDescription() {
        return chosenColorDescription;
    }

    public void setChosenColorDescription(String chosenColorDescription) {
        this.chosenColorDescription = chosenColorDescription;
    }
}
