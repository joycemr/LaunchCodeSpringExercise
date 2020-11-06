package org.launchcode.todo.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class IncomingTodoItem {

    private String text;

    public IncomingTodoItem(String text) {
        this.text = text;
    }

}
