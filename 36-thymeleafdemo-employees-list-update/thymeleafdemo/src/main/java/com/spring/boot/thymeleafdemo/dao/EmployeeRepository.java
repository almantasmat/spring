package com.spring.boot.thymeleafdemo.dao;


import com.spring.boot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    that it. No need to write any code
// add method to sort by last name

    List<Employee> findAllByOrderByLastNameDesc();
}
