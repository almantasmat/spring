package com.spring.boot.craftsoft.service;


import com.spring.boot.craftsoft.dao.TaskRepository;
import com.spring.boot.craftsoft.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task create(Task task) {
       return taskRepository.save(task);
    }

    @Override
    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task findByID(int id) {
        Optional<Task> result = taskRepository.findById(id);
        Task task = null;
        if (result.isPresent()){
            task = result.get();
        }else {
            throw new RuntimeException("Task id: " + id + " not found");
        }
        return task;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

}
