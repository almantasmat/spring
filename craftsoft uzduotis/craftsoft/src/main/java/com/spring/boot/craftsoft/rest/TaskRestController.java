package com.spring.boot.craftsoft.rest;


import com.spring.boot.craftsoft.entity.Task;
import com.spring.boot.craftsoft.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/task/{taskId}")
    public Task getById(@PathVariable @Min(1) @Pattern(regexp = "[0-9]") int taskId) {
        Task task = taskService.findByID(taskId);
        if (task == null) {
            throw new RuntimeException("task Id: " + taskId + " not found");
        }
        return task;
    }

    @PutMapping("/task")
    public Task update(@RequestBody Task task) {
        Task task1 = taskService.findByID(task.getId());
        if (task1 == null) {
            throw new RuntimeException("Task don't exist");
        }
        return taskService.create(task);
    }

    @DeleteMapping("/task/{taskId}")
    public String delete(@PathVariable @Min(1) @Pattern(regexp = "[0-9]") int taskId) {
        Task task = taskService.findByID(taskId);
        if (task == null) {
            throw new RuntimeException("Task id: " + taskId + " not found");
        }
        taskService.delete(taskId);
        return "Task id: " + taskId + " deleted";
    }

    @PostMapping("/task")
    public Task create(@RequestBody Task task) {
        if (task.getId() != 0) {
            task.setId(0);
        }

        return taskService.create(task);
    }
}

