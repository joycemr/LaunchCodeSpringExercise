package org.launchcode.todo.Controllers;

import org.launchcode.todo.Dto.IncomingTask;
import org.launchcode.todo.Dto.OutboundTask;
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

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todos/{todoId}/tasks")
public class TaskController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<Object> getTodoTasks(@PathVariable int todoId) {
        Optional<TodoItem> optionalTodoItem = todoRepository.findById(todoId);
        if (optionalTodoItem.isEmpty()) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        TodoItem todoItem = optionalTodoItem.get();
        List<Task> listOfTasks = todoItem.getTasks();
        // build a list of outbound Task DTO's
        List<OutboundTask> outboundList = new ArrayList<>();
        for (Task task : listOfTasks) {
            outboundList.add(OutboundTask.createOutboundTaskFromTask(task));
        }
        return ResponseEntity.ok().body(outboundList);
    }

    @PostMapping
    public ResponseEntity<Object> postTodoTasks(@PathVariable int todoId, @RequestBody IncomingTask incomingTask) {
        Optional<TodoItem> optionalTodoItem = todoRepository.findById(todoId);
        if (!optionalTodoItem.isPresent()) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        TodoItem todoItem = optionalTodoItem.get();
        Task newTask = new Task(incomingTask.getText());
        newTask.setTodoItem(todoItem);
        newTask = taskRepository.save(newTask);
        OutboundTask newOutboundTask = OutboundTask.createOutboundTaskFromTask(newTask);
        URI location = URI.create("http://localhost:8080/todos/" + newTask.getId() + "/tasks");
        return ResponseEntity.created(location).body(newOutboundTask);
    }
}
