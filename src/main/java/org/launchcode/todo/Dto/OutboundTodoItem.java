package org.launchcode.todo.Dto;

import org.launchcode.todo.Models.TodoItem;

public class OutboundTodoItem {

	private int id;
	private String text;
	private boolean completed;

	public OutboundTodoItem(TodoItem todoItem) {
		this.id = todoItem.getId();
		this.text = todoItem.getText();
		this.completed = todoItem.getCompleted();
	}

	public static OutboundTodoItem createOutboundTodoItemFromTodoItem(TodoItem todoItem) {
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

}
