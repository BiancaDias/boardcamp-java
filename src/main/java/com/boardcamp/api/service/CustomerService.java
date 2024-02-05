package com.boardcamp.api.service;

import java.util.List;

import com.boardcamp.api.models.CustomerModel;
import com.boardcamp.api.repository.CustomerRepository;

public class CustomerService {
  final CustomerRepository customerRepository;

  CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerModel findById(Long id) {
    return customerRepository.findAllById(id).orElseThrow(
      
    )
  }
}
