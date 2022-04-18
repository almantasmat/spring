package com.springbooot.cruddemo.rest;

import com.springbooot.cruddemo.entity.Employee;
import com.springbooot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

//    quick and dirty: inject employee dao use constructor injection

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose employees endpoint and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();
    }
//    add mapping for get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id: " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }
//    add mapping for put/employees
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return  employee;
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId){
       Employee employee = employeeService.findById(empId);
       if (employee == null){
           throw new RuntimeException("Employee id: " + empId + "not found");
       }
       employeeService.deleteById(empId);
       return "delete Employee id: " + empId;
    }
}
