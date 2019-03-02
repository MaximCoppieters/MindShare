package com.pxl.mindshare.repo;

import com.pxl.mindshare.R;
import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {

    private static final PatientRepository instance = new PatientRepository();

    public static PatientRepository getInstance() {
        return instance;
    }

    public void addPatient(Patient newPatient){
        getAll().add(newPatient);
    }

    private PatientRepository() {}

    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();

        Patient patient1 = new Patient( "John", "Doe", "password", "johndoe@gmail.com");
        Patient patient2 = new Patient("Jane", "Roe", "password", "janeroe@gmail.com");
        Patient patient3 = new Patient("Allen", "Smith", "password", "allensmith@gmail.com");
        Patient patient4 = new Patient("Hugh", "Boss", "password", "highboss@gmail.com");
        Patient patient5 = new Patient("Darren", "Dayum", "password", "darrendayum@gmail.com");

        patient1.setImageId(R.drawable.patient1);
        patient2.setImageId(R.drawable.patient2);
        patient3.setImageId(R.drawable.patient3);
        patient4.setImageId(R.drawable.patient4);
        patient5.setImageId(R.drawable.patient5);


        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
        patients.add(patient5);

        for (Patient patient : patients) {
            patient.addTodoItem(new TodoItem("Meet with Eva", "Date at bar at 08:00 PM"));
            patient.addTodoItem(new TodoItem("Go to the cinema", "Watch Deadpool 3 with Dan"));
            patient.addTodoItem(new TodoItem("Call mom", "Ask how she's doing and catch up"));
            patient.addTodoItem(new TodoItem("Go over to Matt's house", "Play Halo 2 with Matt"));
        }

        return patients;
    }
}
