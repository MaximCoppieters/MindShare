package com.pxl.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pxl.mindshare.business.PopupTimerTask;
import com.pxl.mindshare.model.ApplicationState;
import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.model.TodoItem;

import java.util.List;
import java.util.Timer;

public class PersonalProgressionActivity extends AppCompatActivity {

    private ApplicationState<Patient> appState = ApplicationState.getInstance();

    private Patient patient;
    private List<TodoItem> todoItemList;

    private RecyclerView todoRecyclerView;
    private RecyclerView.Adapter todoItemAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Timer showPopUpTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_progression);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        patient = (Patient) appState.getLoggedInUser();

        todoItemList = patient.getTodoList();

        ImageButton panicbutton = findViewById(R.id.panicbutton);
        panicbutton.setOnClickListener((view) -> {
            startActivity(new Intent(this, HelpRequestActivity.class));
        });

        initializePopUpTimer();
    }

    private void initializePopUpTimer() {
        showPopUpTimer = new Timer();

        PopupTimerTask popupTimerTask = new PopupTimerTask(PersonalProgressionActivity.this);
        showPopUpTimer.schedule(popupTimerTask, 8000);
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

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
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


            viewHolder.todoCompletedCheckBox.setOnClickListener(v -> {
                CheckBox cb = (CheckBox) v;
                TodoItem contact = (TodoItem) cb.getTag();

                contact.setSelected(cb.isChecked());
                todoList.get(pos).setSelected(cb.isChecked());
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
