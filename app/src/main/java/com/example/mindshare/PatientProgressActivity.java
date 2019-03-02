package com.example.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mindshare.model.ApplicationState;
import com.example.mindshare.model.Caregiver;
import com.example.mindshare.model.Patient;
import com.example.mindshare.model.TodoItem;
import com.example.mindshare.repo.PatientRepository;

import java.util.List;

public class PatientProgressActivity extends AppCompatActivity {

    private ApplicationState<Caregiver> appState = ApplicationState.getInstance();
    private Patient patient;
    private RecyclerView todoRecyclerView;
    private RecyclerView.Adapter todoItemAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<TodoItem> todoItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_progress);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PatientProgressActivity.this, AddPatientTodoActivity.class));
            }
        });

/*        patient = appState.getSelectedPatient();*/

        patient = PatientRepository.getInstance().getPatients().get(0);

        patient.addTodoItem(new TodoItem("Meet with Eva", "Date at bar at 08:00 PM"));
        patient.addTodoItem(new TodoItem("Go to the cinema", "Watch Deadpool 3 with Dan"));
        patient.addTodoItem(new TodoItem("Call mom", "Ask how she's doing and catch up"));
        patient.addTodoItem(new TodoItem("Go over to Matt's house", "Play Halo 2 with Matt"));

        todoItemList = patient.getTodoList();
        displayPatientNameOnToolBar(toolbar);

        initializeTodoItemRecyclerView();
    }

    private void initializeTodoItemRecyclerView() {
        todoRecyclerView = findViewById(R.id.to_do_recycler_view);

        todoRecyclerView.setHasFixedSize(true);
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        todoItemAdapter = new TodoItemAdapter(todoItemList);
        todoRecyclerView.setAdapter(todoItemAdapter);
    }

    private void displayPatientNameOnToolBar(Toolbar toolbar) {
        toolbar.setTitle(patient.getFullName() + "'s progress");
        setSupportActionBar(toolbar);
    }

    private class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.ViewHolder> {

        private List<TodoItem> todoList;

        public TodoItemAdapter(List<TodoItem> todoItems) {
            this.todoList = todoItems;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.row_todo_select, null);


            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            final int pos = position;
            viewHolder.todoNameTextView.setText(todoList.get(position).getName());
            viewHolder.todoDescriptionTextView.setText(todoList.get(position).getDescription());
            viewHolder.todoCompletedCheckBox.setChecked(todoList.get(position).isSelected());
            viewHolder.todoCompletedCheckBox.setTag(todoList.get(position));


            viewHolder.todoCompletedCheckBox.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    TodoItem contact = (TodoItem) cb.getTag();

                    contact.setSelected(cb.isChecked());
                    todoList.get(pos).setSelected(cb.isChecked());

                    Toast.makeText(
                            v.getContext(),
                            "Clicked on Checkbox: " + cb.getText() + " is "
                                    + cb.isChecked(), Toast.LENGTH_LONG).show();
                }
            });

        }

        // Return the size arraylist
        @Override
        public int getItemCount() {
            return todoList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView todoNameTextView;
            public TextView todoDescriptionTextView;
            public CheckBox todoCompletedCheckBox;
            public TodoItem todoItem;

            public ViewHolder(View itemLayoutView) {
                super(itemLayoutView);

                todoNameTextView = itemLayoutView.findViewById(R.id.tvName);

                todoDescriptionTextView = itemLayoutView.findViewById(R.id.tvEmailId);
                todoCompletedCheckBox = itemLayoutView
                        .findViewById(R.id.chkSelected);

            }

        }

        // method to access in activity after updating selection
        public List<TodoItem> getTodoItemList() {
            return todoList;
        }
    }
}
