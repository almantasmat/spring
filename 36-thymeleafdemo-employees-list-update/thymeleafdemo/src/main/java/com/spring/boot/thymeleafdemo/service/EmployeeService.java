package com.spring.boot.thymeleafdemo.service;



import com.spring.boot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void  save(Employee employee);
    void deleteById(int id);
}
