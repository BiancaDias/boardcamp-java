package com.boardcamp.api.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boardcamp.api.dtos.RentalDTO;
import com.boardcamp.api.exceptions.NotFoundException;
import com.boardcamp.api.exceptions.UnprocessableEntityException;
import com.boardcamp.api.models.CustomerModel;
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

    CustomerModel customer = customerService.findById(dto.getCustomerId());
    GameModel game = gameService.findById(dto.getGameId());

    int originalPrice = game.getPricePerDay() * dto.getDaysRented();

    List<RentalModel> gamesRented = rentalRepository.findAllByGameId(dto.getGameId());
    if(gamesRented.size() == game.getStockTotal()){
      throw new UnprocessableEntityException("This game is not available");
    }
    RentalModel rental = new RentalModel(dto, customer, game, originalPrice );

    return rentalRepository.save(rental);
  }

  public RentalModel update(Long id) {

    RentalModel rental = rentalRepository.findById(id).orElseThrow(
      () -> new NotFoundException("Rental not fount")
    );
    
    if(rental.getRentDate() == null) {
      
      throw new UnprocessableEntityException("This game is already finish");
    }
    Long NewDaysRented = ChronoUnit.DAYS.between(rental.getRentDate(), LocalDate.now());
    rental.setReturnDate(LocalDate.now());
    if(NewDaysRented > rental.getDaysRented()){
      Long delayFee = (NewDaysRented - rental.getDaysRented()) * rental.getGameId().getPricePerDay();
      rental.setDelayFee(delayFee);

    }
    return rentalRepository.save(rental);
  }
}
