package org.launchcode.todo.Controllers;

import org.launchcode.todo.Dto.IncomingTodoItem;
import org.launchcode.todo.Dto.OutboundTodoItem;
import org.launchcode.todo.Models.TodoItem;
import org.launchcode.todo.data.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<Object> getTodos() {
        List<TodoItem> todoItems = todoRepository.findAll();
        List<OutboundTodoItem> outboundTodoItems = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            outboundTodoItems.add(OutboundTodoItem.createOutboundTodoItemFromTodoItem(todoItem));
        }
        return ResponseEntity.status(200).body(outboundTodoItems);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTodoById(@PathVariable int id) {
        Optional<TodoItem> todoItem = todoRepository.findById(id);
        if (todoItem.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        TodoItem item = todoItem.get();
        OutboundTodoItem outgoingTodoItem = OutboundTodoItem.createOutboundTodoItemFromTodoItem(item);
        return ResponseEntity.status(200).body(outgoingTodoItem);
    }

    @PostMapping
    public ResponseEntity<Object> postTodo(@RequestBody IncomingTodoItem todoDto) {
        TodoItem todoItem = TodoItem.createItem(todoDto.getText());
        TodoItem updatedItem = todoRepository.save(todoItem);
        return ResponseEntity.status(201).body(updatedItem);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> patchTodo(@PathVariable int id) {
        Optional<TodoItem> todoItem = todoRepository.findById(id);
        if(todoItem.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        TodoItem updatedTodo = todoItem.get().markAsComplete();
        updatedTodo = todoRepository.save(updatedTodo);
        OutboundTodoItem outgoingTodoItem = OutboundTodoItem.createOutboundTodoItemFromTodoItem(updatedTodo);
        return ResponseEntity.status(200).body(outgoingTodoItem);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable int id) {
        Optional<TodoItem> todoItem = todoRepository.findById(id);
        if(todoItem.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        todoRepository.delete(todoItem.get());
        return ResponseEntity.status(204).build();
    }
    
}
