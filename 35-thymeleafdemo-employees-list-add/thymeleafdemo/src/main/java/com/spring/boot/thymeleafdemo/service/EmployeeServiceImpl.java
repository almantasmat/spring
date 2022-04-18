package com.spring.boot.thymeleafdemo.service;


import com.spring.boot.thymeleafdemo.dao.EmployeeRepository;
import com.spring.boot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAllByOrderByLastNameDesc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()){
            employee = result.get();
        }else {
//            we didn't find employee
            throw new RuntimeException("did not found employee id: " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }
}
