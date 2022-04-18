package com.spring.boot.thymeleafdemo.controller;

import com.spring.boot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
//    load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData(){
//        create employees
        Employee employee1 = new Employee(1, "Jonukas", "Jonaitis", "Jonas@one.lt");
        Employee employee2 = new Employee(1, "Petriukas", "Petraitis", "Petras@one.lt");
        Employee employee3 = new Employee(1, "Juozukas", "Juozaitis", "Juozas@one.lt");

//        create list
        employees = new ArrayList<>();
//        add to list
//        employees = List.of(employee1, employee2, employee3);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }
    //        add maping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employees);
        return "list-employees";
    }

}
