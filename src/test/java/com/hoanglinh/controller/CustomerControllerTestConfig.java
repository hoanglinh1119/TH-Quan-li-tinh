package com.hoanglinh.controller;


import com.hoanglinh.service.CustomerService;
import com.hoanglinh.service.ProvinceService;
import com.hoanglinh.service.impl.CustomerServiceImpl;
import com.hoanglinh.service.impl.ProvinceServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.hoanglinh.controllers")
public class CustomerControllerTestConfig {
    @Bean
    public CustomerService customerService(){
        return Mockito.mock(CustomerServiceImpl.class);

    }
    @Bean
    public ProvinceService provinceService() {
        return Mockito.mock(ProvinceServiceImpl.class);
    }
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("customerProvince")
                .build();
    }
}
