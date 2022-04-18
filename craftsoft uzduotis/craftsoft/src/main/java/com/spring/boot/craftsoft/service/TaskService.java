package com.spring.boot.craftsoft.service;





import com.spring.boot.craftsoft.entity.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    void delete(int id);
    Task findByID(int id);
    List<Task> getAll();
}
