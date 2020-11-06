package org.launchcode.todo.Controllers;

import org.launchcode.todo.Dto.OutboundTodoReportItem;
import org.launchcode.todo.Models.TodoItem;
import org.launchcode.todo.data.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todosreport")
public class TodoReportController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<Object> getTodos() {
        List<TodoItem> todoItems = todoRepository.findAll();
        List<OutboundTodoReportItem> outboundTodoReportItems = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            outboundTodoReportItems.add(OutboundTodoReportItem.createOutboundTodoReportItemFromTodoItem(todoItem));
        }
        return ResponseEntity.status(200).body(outboundTodoReportItems);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getTodoById(@PathVariable int id) {
		Optional<TodoItem> todoItem = todoRepository.findById(id);
		if (todoItem.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		TodoItem item = todoItem.get();
		OutboundTodoReportItem outgoingTodoReportItem = OutboundTodoReportItem.createOutboundTodoReportItemFromTodoItem(item);
		return ResponseEntity.status(200).body(outgoingTodoReportItem);
	}

}
