package com.boardcamp.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boardcamp.api.dtos.CustomerDTO;
import com.boardcamp.api.exceptions.NotFoundException;
import com.boardcamp.api.models.CustomerModel;
import com.boardcamp.api.repository.CustomerRepository;

@Service
public class CustomerService {
  final CustomerRepository customerRepository;

  CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerModel findById(Long id) {
    return customerRepository.findById(id).orElseThrow(
      () -> new NotFoundException("User not found by this id")
    );
  }

  public Optional<CustomerModel> save(CustomerDTO dto) {
    if(customerRepository.existsByCpf(dto.getCpf())) {
      throw new NotFoundException("This CPF already exists!");
    }
    CustomerModel customer = new CustomerModel(dto);
    return Optional.of(customerRepository.save(customer));
  }
}
