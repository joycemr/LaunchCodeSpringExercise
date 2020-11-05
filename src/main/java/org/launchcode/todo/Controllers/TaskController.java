package org.launchcode.todo.Controllers;

import org.launchcode.todo.Models.IncomingTask;
import org.launchcode.todo.Models.Task;
import org.launchcode.todo.Models.TodoItem;
import org.launchcode.todo.data.TaskRepository;
import org.launchcode.todo.data.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/todos/{id}/tasks")
public class TaskController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TaskRepository TaskRepository;

    @GetMapping
    public ResponseEntity<Object> getTodoTasks(@PathVariable int id) {
        return ResponseEntity.status(418).build();
    }

    @PostMapping
    public ResponseEntity<Object> postTodoTasks(@PathVariable int id, @RequestBody IncomingTask incomingTask) {
        Optional<TodoItem> optionalTodoItem = todoRepository.findById(id);
        if (!optionalTodoItem.isPresent()) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        TodoItem todoItem = optionalTodoItem.get();
        Task newTask = new Task(incomingTask.getText());
        todoItem.addTask(newTask);
        todoRepository.save(todoItem);
        // TODO If I'm saving only the parent, how best to get the newTask.id?
        return ResponseEntity.ok().body(newTask);
    }
}
