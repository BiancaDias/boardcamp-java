package com.boardcamp.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boardcamp.api.models.RentalModel;
import com.boardcamp.api.repository.RentalRepository;

@Service
public class RentalService {
  final RentalRepository rentalRepository;

  RentalService(RentalRepository rentalRepository){
    this.rentalRepository = rentalRepository;
  }

  public List<RentalModel> findAll(){
    return rentalRepository.findAll();
  }
}