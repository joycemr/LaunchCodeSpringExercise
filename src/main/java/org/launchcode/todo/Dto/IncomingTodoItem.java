package org.launchcode.todo.Dto;

public class IncomingTodoItem {

    private String text;

    public IncomingTodoItem() {}

    public IncomingTodoItem(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
