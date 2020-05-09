package com.hoanglinh.service;

import com.hoanglinh.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService  {
Page<Customer> findAll(Pageable pageable);
Customer findById(Long id);
void save(Customer customer);
void delete (Long id);
Page<Customer> findAllByOrderByNameDesc(Pageable p);



}
