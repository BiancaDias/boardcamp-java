package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GameDTO {

  @NotBlank
  @Size(max = 150, message = "Maximun length for name is 150 characters")
  private String name;

  private String image;

  @NotNull
  @Positive
  private int stockTotal;

  @NotNull
  @Positive
  private int pricePerDay;
}
