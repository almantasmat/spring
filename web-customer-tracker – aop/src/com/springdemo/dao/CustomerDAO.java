package com.springdemo.dao;

import com.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void delete(int id);
}
