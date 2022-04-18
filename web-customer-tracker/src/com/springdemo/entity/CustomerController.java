package com.springdemo.entity;

import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
//    need to inject customerService

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model model){

//        get customers from DAO
      List<Customer> customers = customerService.getCostomers();

//        add customer to model
      model.addAttribute("customers", customers);
        return "list-customer";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
//        create model atribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
//        save customer using service
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
   public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
//     get customer from database
        Customer customer = customerService.getCustomer(id);
//        set customer as model attribute to prepopulate form
        model.addAttribute("customer", customer);
//        send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
