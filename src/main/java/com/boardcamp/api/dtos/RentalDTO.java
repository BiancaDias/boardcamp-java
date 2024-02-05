package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RentalDTO {
  
  @NotNull
  private Long customerId;

  @NotNull
  private Long gameId;

  @NotNull
  private int daysRented;
}
