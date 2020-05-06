package com.hoanglinh.service.impl;

import com.hoanglinh.model.Customer;
import com.hoanglinh.repository.CustomerRepository;
import com.hoanglinh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
