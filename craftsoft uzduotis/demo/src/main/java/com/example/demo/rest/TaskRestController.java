package com.example.demo.rest;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {


    private TaskService taskService;

    @Autowired
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAll(){
       return taskService.getAll();
    }

    @PostMapping("/task")
    public Task create(@RequestBody Task task){
         if(task.getId() != 0){
             task.setId(0);
         }
         taskService.create(task);
         return task;
    }
}

