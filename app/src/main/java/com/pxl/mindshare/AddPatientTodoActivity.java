package com.pxl.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.pxl.mindshare.business.ApplicationState;
import com.pxl.mindshare.model.Caregiver;
import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.model.TodoItem;
import com.pxl.mindshare.repo.TodoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AddPatientTodoActivity extends AppCompatActivity {

    private TodoRepository todoRepository = TodoRepository.getInstance();
    private ApplicationState<Caregiver> appState = ApplicationState.getInstance();

    private Spinner todoSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_todo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Patient patient = appState.getSelectedPatient();

        List<String> todoListNames = todoRepository.getAll()
                .stream()
                .map(todoItem -> todoItem.getName())
                .collect(Collectors.toList());

        Button assignToDoButton = findViewById(R.id.assign_to_do_button);
        todoSpinner = findViewById(R.id.todo_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, todoListNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        todoSpinner = findViewById(R.id.todo_spinner);
        todoSpinner.setAdapter(adapter);


        assignToDoButton.setOnClickListener(view -> {
            String selectedToDoTaskName = todoSpinner.getSelectedItem().toString();

            if (selectedToDoTaskName.isEmpty() || selectedToDoTaskName == null) {
                    findViewById(R.id.to_do_selection_warning)
                            .setVisibility(View.VISIBLE);
            } else {
                TodoItem todoItem = todoRepository.getByName(selectedToDoTaskName);

                patient.addTodoItem(todoItem);

                startActivity(new Intent(AddPatientTodoActivity.this, PatientProgressionActivity.class));
            }
        });
    }

}
