package com.pxl.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.pxl.mindshare.model.Caregiver;
import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.repo.CaregiverRepository;
import com.pxl.mindshare.repo.PatientRepository;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    private CaregiverRepository caregiverRepository;
    private PatientRepository patientRepository;
    private Map<String, String> valuesFromSignUpForm = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeAppUserRepositories();
        findViewById(R.id.sign_up__activity_sign_up_button).setOnClickListener((view) -> {
            RadioButton careGiverRadioButton = findViewById(R.id.care_taker_radio_button);
            RadioButton userRadioButton = findViewById(R.id.user_radio_button);
            if (careGiverRadioButton.isChecked()) {
                Caregiver newCareGiver = new Caregiver(
                        valuesFromSignUpForm.get("firstname"),
                        valuesFromSignUpForm.get("lastname"),
                        valuesFromSignUpForm.get("password"),
                        valuesFromSignUpForm.get("email"));
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Care giver added",
                        Toast.LENGTH_SHORT);
                toast.show();
                goBackAutomatic();

            } else {
                if (userRadioButton.isChecked()) {
                    Patient newPatient = new Patient(valuesFromSignUpForm.get("firstname"),
                            valuesFromSignUpForm.get("lastname"),
                            valuesFromSignUpForm.get("password"),
                            valuesFromSignUpForm.get("email"));
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "User added",
                            Toast.LENGTH_SHORT);

                    toast.show();
                    goBackAutomatic();


                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Form has not been filled in correctly!",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    goBackAutomatic();
                }
            }

        });
    }

    private void goBackAutomatic() {
        try {
            Thread.sleep((long) Toast.LENGTH_LONG);
            startActivity(new Intent(SignUpActivity.this, UserLoginActivity.class));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initializeAppUserRepositories() {
        caregiverRepository = CaregiverRepository.getInstance();
        patientRepository = PatientRepository.getInstance();
    }

    private boolean checkIfAllIsFilledIn() {
        valuesFromSignUpForm = new HashMap<>();
        String firstName = findViewById(R.id.sign_up_first_name).getTooltipText().toString();
        String lastName = findViewById(R.id.sign_up_last_name).getTooltipText().toString();
        String email = findViewById(R.id.sign_up_email_text_box).getTooltipText().toString();
        String password = findViewById(R.id.password_text_box).getTooltipText().toString();
        String reconfirmPassword = findViewById(R.id.reconfirm_password_text_box).getTooltipText().toString();

        valuesFromSignUpForm.put("firstname", firstName);
        valuesFromSignUpForm.put("lastname", lastName);
        valuesFromSignUpForm.put("email", email);
        if (password.equals("") &&
                reconfirmPassword.equals("") &&
                password.equals(reconfirmPassword)) {
            valuesFromSignUpForm.put("password", password);
            valuesFromSignUpForm.put("reconfirmPassword", reconfirmPassword);
        } else {
            return false;
        }

        boolean[] isThereAnEmptyField = new boolean[1];
        isThereAnEmptyField[0] = true;
        valuesFromSignUpForm.forEach((k, v) -> {
            if (v.equals("")) {
                isThereAnEmptyField[0] = false;
                return;
            }
        });

        return isThereAnEmptyField[0];
    }

}
