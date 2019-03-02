package com.pxl.mindshare.model;

public class TodoItem {

    private String name;
    private String description;
    private boolean selected;

    public TodoItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
