package org.launchcode.todo.Dto;

import org.launchcode.todo.Models.Task;
import org.launchcode.todo.Models.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class OutboundTodoReportItem {

	private int id;
	private String text;
	private boolean completed;
	private List<OutboundTask> tasks = new ArrayList<>();

	public OutboundTodoReportItem(TodoItem todoItem) {
		this.id = todoItem.getId();
		this.text = todoItem.getText();
		this.completed = todoItem.getCompleted();
		for (Task task : todoItem.getTasks()) {
			this.tasks.add(OutboundTask.createOutboundTaskFromTask(task));
		}
	}

	public static OutboundTodoReportItem createOutboundTodoReportItemFromTodoItem(TodoItem todoItem) {
		return new OutboundTodoReportItem(todoItem);
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


	public List<OutboundTask> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<OutboundTask> tasks) {
		this.tasks = tasks;
	}

}
