package com.spring.boot.thymeleafdemo.dao;


import com.spring.boot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    that it. No need to write any code
}
