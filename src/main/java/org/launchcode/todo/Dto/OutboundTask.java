package org.launchcode.todo.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.launchcode.todo.Models.Task;

@NoArgsConstructor
@Getter
@Setter
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

}
