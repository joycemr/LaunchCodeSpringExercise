package org.launchcode.todo.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class IncomingTask {

	private String text;

	public IncomingTask(String text) {
		this.text = text;
	}

}
