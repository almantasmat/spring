package com.example.demo.service;

import com.example.demo.entity.Task;

import java.util.List;

public interface TaskService {
    void create(Task task);
    void delete(int id);
    Task findByID(int id);
    List<Task> getAll();

}
