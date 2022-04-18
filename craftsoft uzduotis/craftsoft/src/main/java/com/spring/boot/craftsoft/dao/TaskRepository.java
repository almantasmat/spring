package com.spring.boot.craftsoft.dao;

import com.spring.boot.craftsoft.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Integer>{
}
