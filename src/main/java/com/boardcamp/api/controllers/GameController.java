package com.boardcamp.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boardcamp.api.dtos.GameDTO;
import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.service.GameService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {
  final GameService gameService;

  GameController(GameService gameService){
    this.gameService = gameService;
  }

  @GetMapping
  public ResponseEntity<Object> getGames() {
    List<GameModel> game = gameService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(game);
  }

  @PostMapping
  public ResponseEntity<Object> createGame(@RequestBody @Valid GameDTO body){
    Optional<GameModel> game = gameService.save(body);
    return ResponseEntity.status(HttpStatus.CREATED).body(game);
  }
}
