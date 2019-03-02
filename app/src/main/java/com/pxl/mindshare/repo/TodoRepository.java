package com.pxl.mindshare.repo;

import com.pxl.mindshare.model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private static final TodoRepository todoRepository = new TodoRepository();
    private List<TodoItem> todoList;

    private TodoRepository() {
        todoList = new ArrayList<>();
        initializeTodoRepository();
    }

    public static TodoRepository getInstance() {
        return todoRepository;
    }

    private void initializeTodoRepository() {
        todoList.add(new TodoItem("Call a friend or family member", "Talking with people you care about is shown to have positive psychological benifits"));
        todoList.add(new TodoItem("Go for a walk", "Going out for a walk is a good way to clear up your mind, feel free to take someone with you!"));
        todoList.add(new TodoItem("Try to make your bed", "Making your bed can be the start of fullfilling day, it is shown to be a rewarding activity."));
        todoList.add(new TodoItem("Watch your favorite TV show or movie", "Doing something you enjoy is a good to way to find meaning in your life"));
        todoList.add(new TodoItem("Try out a new cooking recipe", "Trying out new things is a good way to create excitement in your live. Ever had chinese Mapu Doufu? Delicious!"));
        todoList.add(new TodoItem("Visit the zoo or tend to other local animals", "Humans form a special bond with animals, and sometimes their silence is all we need!"));
        todoList.add(new TodoItem("Bike to a nearby city or village", "Biking is a good form cardio exercise, which is proven to help keep an elevated emotional state!"));
    }

    public List<TodoItem> getAll() {
        return todoList;
    }

    public TodoItem getByName(String todoItemName) {
        return todoList.stream()
                .filter(todoItem -> todoItem.getName().equals(todoItemName))
                .findFirst()
                .get();
    }

}
