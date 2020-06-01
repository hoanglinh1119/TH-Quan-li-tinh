package com.hoanglinh.service;

import com.hoanglinh.repository.CustomerRepository;
import com.hoanglinh.service.impl.CustomerServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.hoanglinh.service")
public class CustomerServiceTestConfig {
    @Bean
    public CustomerRepository customerRepository(){
        return Mockito.mock(CustomerRepository.class);
    }
    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }
}
