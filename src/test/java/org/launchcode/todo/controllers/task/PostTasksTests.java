package org.launchcode.todo.controllers.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.launchcode.todo.IntegrationTestConfig;
import org.launchcode.todo.Models.IncomingTask;
import org.launchcode.todo.Models.TodoItem;
import org.launchcode.todo.data.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@IntegrationTestConfig
public class PostTasksTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TodoRepository todoRepository;

    @Test
    @DisplayName(value = "POST /todos/{id}/tasks Not Found")
    public void postTodoTasksNotFound() throws Exception {
        IncomingTask testIncomingTask = new IncomingTask("This is a test task");
        String testIncomingTaskString = new ObjectMapper().writeValueAsString(testIncomingTask);
        mockMvc.perform(MockMvcRequestBuilders.post("/todos/5000/tasks").contentType(MediaType.APPLICATION_JSON)
                .content(testIncomingTaskString)).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName(value = "POST /todos/{id}/tasks")
    public void postTodoTasks() throws Exception {
        TodoItem testTodo = TodoItem.createItem("This is a test todo");
        testTodo = todoRepository.save(testTodo);
        IncomingTask testIncomingTask = new IncomingTask("This is a test task");
        String testIncomingTaskString = new ObjectMapper().writeValueAsString(testIncomingTask);
        mockMvc.perform(MockMvcRequestBuilders.post("/todos/" + testTodo.getId() + "/tasks")
                .contentType(MediaType.APPLICATION_JSON).content(testIncomingTaskString))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").value(testIncomingTask.getText()));
    }
}
