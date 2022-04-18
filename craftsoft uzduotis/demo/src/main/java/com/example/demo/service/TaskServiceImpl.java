package com.example.demo.service;

import com.example.demo.dao.TaskRepository;
import com.example.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void create(Task task) {
        taskRepository.save(task);
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
