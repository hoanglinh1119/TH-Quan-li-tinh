package com.hoanglinh.service;

import com.hoanglinh.model.Customer;

public interface CustomerService  {
Iterable<Customer> findAll();
Customer findById(Long id);
void save(Customer customer);
void delete (Long id);


}
