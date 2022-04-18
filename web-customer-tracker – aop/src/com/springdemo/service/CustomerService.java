package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.Customer;



public interface CustomerService {
List<Customer> getCostomers();
void saveCustomer(Customer customer);
Customer getCustomer(int id);
void delete(int id);
}
