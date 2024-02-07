package com.boardcamp.api.models;

import java.time.LocalDate;

import com.boardcamp.api.dtos.RentalDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rentals")
public class RentalModel {

  public RentalModel(RentalDTO dto, int originalPrice) {
    //this.customerId = new CustomerModel();
    //this.customerId.setId(dto.getCustomerId());
    //this.gameId = new GameModel();
    //this.gameId.setId(dto.getGameId());
    this.daysRented = dto.getDaysRented();
    this.originalPrice = originalPrice;
    this.delayFee = 0;
  }

  public RentalModel(RentalDTO dto, CustomerModel customer, GameModel game, int originalPrice){
    this.daysRented = dto.getDaysRented();
    this.originalPrice = originalPrice;
    this.delayFee = 0;
    this.customerId = customer;
    this.gameId = game;
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(nullable = false)
  private CustomerModel customerId;

  @Column(nullable = false)
  private GameModel gameId;

  @Column(nullable = false)
  private LocalDate rentDate;

  @Column(nullable = false)
  private int daysRented;

  @Column(nullable = true)
  private LocalDate returnDate;

  @Column(nullable = false)
  private int originalPrice;

  @Column(nullable = false)
  private int delayFee;
}
