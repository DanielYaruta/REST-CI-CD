package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Buy groceries", "Milk, eggs, bread"));
        tasks.add(new Task(2L, "Read book", "Finish reading Clean Code"));
        tasks.add(new Task(3L, "Exercise", "30 minutes cardio"));
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}
