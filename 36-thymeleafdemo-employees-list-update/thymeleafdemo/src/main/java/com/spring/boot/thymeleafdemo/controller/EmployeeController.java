package com.spring.boot.thymeleafdemo.controller;

import com.spring.boot.thymeleafdemo.entity.Employee;
import com.spring.boot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "/employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
//        create model attribute to bind for data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
//        Save employee
        employeeService.save(employee);
//        redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
//        get employee from service
        Employee employee = employeeService.findById(id);
//        set employee as attribute to prepopulate form
        model.addAttribute("employee", employee);
//        send to form
        return "/employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
