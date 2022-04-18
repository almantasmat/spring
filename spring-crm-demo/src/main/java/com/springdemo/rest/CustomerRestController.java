package com.springdemo.rest;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
//    autowired customer service
    @Autowired
    private CustomerService customerService;

//    add mapping for get ?customer
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return  customerService.getCustomers();
    }
//    add mapping for get /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public  Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null){
            throw new CustomerNotFoundException("Customer ID not found: " + customerId);
        }
        return customer;
    }
//    Add maping for post/customers-add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
//        just on case, client will pass id on json, set id to 0
//        this will force to save new item instead of update
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }
//    Add mapping for update(put)/ customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }
//    add mapping for delete /customer/customerId - delete existing customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
       Customer customer = customerService.getCustomer(customerId);
//       throw exception if null
        if (customer == null){
            throw new CustomerNotFoundException("Customer id : " + customerId + "not found");
        }
        customerService.deleteCustomer(customerId);
        return "Delete customer id : " + customerId;
    }
}
