package com.springbooot.cruddemo.dao;

import com.springbooot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    that it. No need to write any code
}
