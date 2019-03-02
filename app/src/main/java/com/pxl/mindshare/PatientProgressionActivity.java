package com.pxl.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pxl.mindshare.business.ApplicationState;
import com.pxl.mindshare.model.Caregiver;
import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.model.TodoItem;

import java.util.List;

public class PatientProgressionActivity extends AppCompatActivity {

    private ApplicationState<Caregiver> appState = ApplicationState.getInstance();
    private Patient patient;
    private RecyclerView todoRecyclerView;
    private RecyclerView.Adapter todoItemAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<TodoItem> todoItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_progression);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            startActivity(new Intent(PatientProgressionActivity.this, AddPatientTodoActivity.class));
        });

        patient = appState.getSelectedPatient();


        todoItemList = patient.getTodoList();
        displayPatientNameOnToolBar(toolbar);

        initializeTodoItemRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();

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
