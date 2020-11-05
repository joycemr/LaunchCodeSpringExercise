package org.launchcode.todo.Dto;

import org.launchcode.todo.Models.Task;
import org.launchcode.todo.Models.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class OutboundTodoItem {

	private int id;
	private String text;
	private boolean completed;
	private List<Task> tasks = new ArrayList<>();

	public OutboundTodoItem(TodoItem todoItem) {
		this.id = todoItem.getId();
		this.text = todoItem.getText();
		this.completed = todoItem.getCompleted();
		this.tasks = todoItem.getTasks();
	}

	public static OutboundTodoItem outgoingTodoItemFromTodoItem(TodoItem todoItem) {
		return new OutboundTodoItem(todoItem);
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCompleted() {
		return this.completed;
	}

	public boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
