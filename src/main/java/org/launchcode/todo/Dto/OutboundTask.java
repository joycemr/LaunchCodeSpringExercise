package org.launchcode.todo.Dto;

import org.launchcode.todo.Models.Task;

public class OutboundTask {

	private Integer id;
	private String text;

	public OutboundTask(Task task) {
		this.id = task.getId();
		this.text = task.getText();
	}

	public static OutboundTask createOutboundTaskFromTask(Task task) {
		return new OutboundTask(task);
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

}
