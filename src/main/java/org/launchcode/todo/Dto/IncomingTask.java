package org.launchcode.todo.Dto;

public class IncomingTask {

	private String text;

	public IncomingTask() {}

	public IncomingTask(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
