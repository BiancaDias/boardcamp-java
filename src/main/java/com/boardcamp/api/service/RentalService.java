package com.boardcamp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boardcamp.api.dtos.RentalDTO;
import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.models.RentalModel;
import com.boardcamp.api.repository.GameRepository;
import com.boardcamp.api.repository.RentalRepository;

@Service
public class RentalService {
  final RentalRepository rentalRepository;
  final GameRepository gameRepository;
  final CustomerService customerService;
  final GameService gameService;

  RentalService(GameService gameService, RentalRepository rentalRepository, GameRepository gameRepository, CustomerService customerService){
    this.rentalRepository = rentalRepository;
    this.gameRepository = gameRepository;
    this.customerService = customerService;
    this.gameService = gameService;
  }

  public List<RentalModel> findAll(){
    return rentalRepository.findAll();
  }

  public RentalModel save(RentalDTO dto){

    customerService.findById(dto.getCustomerId());
    GameModel game = gameService.findById(dto.getGameId());

    int originalPrice = game.getPricePerDay() * dto.getDaysRented();
    
    RentalModel rental = new RentalModel(dto, originalPrice );
    return rentalRepository.save(rental);
  }
}
