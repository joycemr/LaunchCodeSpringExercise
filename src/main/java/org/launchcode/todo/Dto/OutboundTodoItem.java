package org.launchcode.todo.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.launchcode.todo.Models.TodoItem;

@NoArgsConstructor
@Getter
@Setter
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

}
