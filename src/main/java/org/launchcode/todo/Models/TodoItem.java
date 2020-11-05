package org.launchcode.todo.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * TodoItem Interface
 * use this interface to guide the implementation of the TodoItem class
 */
interface ITodoItem {
  int getId();
  String getText();
  boolean getCompleted();
  TodoItem markAsComplete();
}

@Entity
public class TodoItem implements ITodoItem {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String text;
  private boolean completed;

  public int getId() {
    return this.id;
  }

  public String getText() {
    return this.text;
  }

  public boolean getCompleted() {
    return this.completed;
  }

  @Override
  public TodoItem markAsComplete() {
    this.completed = true;
    return this;
  }

  private TodoItem(String text) {
    this.text = text;
    this.completed = false;
  }

  public TodoItem() {}

  public static TodoItem createItem(String text) {
    TodoItem todoItem = new TodoItem(text);
    
    return todoItem;
  }

  @OneToMany(mappedBy = "id", cascade = { CascadeType.ALL })
  private List<Task> tasks = new ArrayList<>();

}