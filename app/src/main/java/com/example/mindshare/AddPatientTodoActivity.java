package com.example.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mindshare.model.ApplicationState;
import com.example.mindshare.model.Caregiver;
import com.example.mindshare.model.Patient;
import com.example.mindshare.model.TodoItem;

public class AddPatientTodoActivity extends AppCompatActivity {

    private ApplicationState<Caregiver> appState = ApplicationState.getInstance();
    private EditText todoNameEditText;
    private EditText todoDescriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_todo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Patient patient = appState.getSelectedPatient();

        Button assignToDoButton = findViewById(R.id.assign_to_do_button);
        todoNameEditText = findViewById(R.id.to_do_name);
        todoDescriptionEditText = findViewById(R.id.to_do_description);

        assignToDoButton.setOnClickListener(view -> {
            String todoName = todoNameEditText.getText().toString();
            String todoDescription = todoDescriptionEditText.getText().toString();

            if (todoName.isEmpty() || todoDescription.isEmpty()) {
                if (todoName.isEmpty()) {
                    findViewById(R.id.to_do_name_waring)
                            .setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.to_do_description_warning)
                            .setVisibility(View.VISIBLE);
                }
            } else {
                TodoItem assignedTodoItem = new TodoItem(todoName, todoDescription);
                patient.addTodoItem(assignedTodoItem);

                startActivity(new Intent(AddPatientTodoActivity.this, PatientProgressActivity.class));
            }
        });
    }

}
