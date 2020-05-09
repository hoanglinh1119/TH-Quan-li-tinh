package com.hoanglinh.repository;

import com.hoanglinh.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByOrderByNameDesc(Pageable p);
//    Page<Customer> findAllByOrOrderByNameAsc(Pageable p);
}
