package org.launchcode.todo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "todo_item_id", nullable = false)
    private TodoItem todoItem;

    public Task() {}

    public Task(String text) {
        this.text = text;
    }

    public Task(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Task(TodoItem todoItem, String text) {
        this.todoItem = todoItem;
        this.text = text;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TodoItem getTodoItem() {
        return this.todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

}
