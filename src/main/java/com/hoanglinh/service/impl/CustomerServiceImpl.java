package com.hoanglinh.service.impl;

import com.hoanglinh.model.Customer;
import com.hoanglinh.repository.CustomerRepository;
import com.hoanglinh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
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

    @Override
    public Page<Customer> findAllByOrderByNameDesc(Pageable p) {
        return customerRepository.findAllByOrderByNameDesc(p);
    }
}
