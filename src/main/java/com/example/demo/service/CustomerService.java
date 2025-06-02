package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAlldustomers();

    String deleteCustomer(int customerId);
}
