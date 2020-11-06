package org.launchcode.todo.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.launchcode.todo.Models.Task;
import org.launchcode.todo.Models.TodoItem;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
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

}
