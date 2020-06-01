package com.hoanglinh.controller;


import com.hoanglinh.controllers.CustomerController;
import com.hoanglinh.model.Customer;
import com.hoanglinh.service.CustomerService;
import com.hoanglinh.service.ProvinceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@SpringJUnitJupiterConfig(CustomerControllerTestConfig.class)
public class CustomerControllerTest {
    @Autowired
    CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;
    private MockMvc mockMvc;
    @InjectMocks
    private CustomerController customerController;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(customerController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).build();
    }

    @Test
    void customersListPageIsExists() throws Exception {
        mockMvc.perform(get("/customers")).andExpect(status().isOk())
        .andExpect(view().name("/customer/list"));
    }
    @Test
    void customerUpdateSuccessControlling() throws Exception {
        Customer foo = new Customer(1L, "Foo Bar", "a@dummy.im", "Nowhere");
        when(customerService.save(isA(Customer.class))).thenReturn(foo);

        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", foo.getId().toString())
                .param("name", foo.getName())
                .param("email", foo.getEmail())
                .param("contact",foo.getContact())
                 .param("province",foo.getProvince().getName())   )
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/customers"));
    }


}
